using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Text.Json;

namespace servidor
{
    internal class ShiftServer
    {
        private Socket MainSocket;
        private string[] Users { get; set; }
        private List<string> WaitQueue { get; set; } = new List<string>();
        private bool ServerRunning { get; set; } = true;
        private int Port { get; set; } = 4321;
        private readonly object key = new object();
        private string JSONPath = $"{Environment.GetEnvironmentVariable("USERPROFILE")}/datos.json";

        public void Init()
        {


            if (File.Exists(JSONPath))
            {
                WaitQueue = InitWaitQueue(JSONPath);
            }

            using (MainSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                bool trigger = false;
                IPEndPoint ie = null;

                while (!trigger && Port <= 65535 && Port > 1024)
                {
                    try
                    {
                        ie = new IPEndPoint(IPAddress.Any, Port);
                        MainSocket.Bind(ie);
                        trigger = true;
                    }
                    catch (SocketException e)
                    {
                        if (e.ErrorCode == 10048)
                        {
                            Console.WriteLine($"Error: Puerto {Port} ocupado, probando con el siguiente...");
                            Port++;
                        }
                    }
                }

                MainSocket.Listen(10);
                Console.WriteLine($"Servidor iniciado {ie.Address}:{Port}:");
                Console.WriteLine($"Esperando conexiones... (Ctrl+C para salir)");

                while (ServerRunning)
                {
                    try
                    {
                        Socket client = MainSocket.Accept();
                        Thread hilo = new Thread(() => ClientDispatcher(client));

                        hilo.Start();
                    }
                    catch (SocketException e)
                    {
                        ServerRunning = false;
                    }
                }
            }
        }

        private void ClientDispatcher(Socket sClient)
        {
            try
            {
                using (sClient)
                {
                    IPEndPoint ieClient = (IPEndPoint)sClient.RemoteEndPoint;
                    Console.WriteLine($"Cliente conectado:{ieClient.Address} " + $"en puerto {ieClient.Port}");
                    Encoding codificacion = Console.OutputEncoding;

                    using (NetworkStream ns = new NetworkStream(sClient))
                    using (StreamReader sr = new StreamReader(ns, codificacion))
                    using (StreamWriter sw = new StreamWriter(ns, codificacion))
                    {
                        bool isAdmin = false;
                        bool stopClient = false;
                        string finalMessage = "Conexión terminada";
                        string command;
                        string usersPath = Environment.GetEnvironmentVariable("USERPROFILE") + "/usuarios.txt";
                        string passwordPath = Environment.GetEnvironmentVariable("USERPROFILE") + "/pin.txt";

                        ReadNames(usersPath);

                        sw.AutoFlush = true;
                        sw.WriteLine("------- LISTA DE ESPERA -------");

                        sw.Write("Introduce tu nombre de usuario: ");

                        string username = sr.ReadLine();

                        if (username == "admin")
                        {
                            sw.Write("Introduce la contraseña: ");
                            string password = sr.ReadLine();

                            if (password == ReadPin(passwordPath).ToString())
                            {
                                sw.WriteLine("Usuario verificado con éxito");

                                isAdmin = true;
                            }
                            else
                            {
                                sw.WriteLine("Contraseña incorrecta");
                                sClient.Close();
                            }
                        }

                        if (!Users.Contains(username) && username != "admin")
                        {
                            sw.WriteLine("Usuario desconocido");
                            sClient.Close();
                        }
                        else
                        {
                            try
                            {
                                while (!stopClient && (command = sr.ReadLine()) != null)
                                {
                                    string[] parts = command.Split(" ", 2);
                                    string cmd = parts[0];
                                    string? arg = parts.Length > 1 ? parts[1] : null;

                                    switch (cmd)
                                    {
                                        case "add":

                                            string userFormatted = $"{username};{DateTime.Now}";

                                            lock (key)
                                            {
                                                bool usernameExist = WaitQueue.Any(u => u.Split(";")[0] == username);

                                                if (usernameExist)
                                                {
                                                    finalMessage = "Este usuario ya está en la lista.";
                                                }
                                                else
                                                {
                                                    WaitQueue.Add(userFormatted);
                                                    finalMessage = "Usuario añadido en la lista.";
                                                }
                                            }

                                            if (isAdmin == false)
                                            {
                                                stopClient = true;
                                            }
                                            else
                                            {
                                                sw.WriteLine(finalMessage);
                                            }

                                            break;
                                        case "list":

                                            sw.WriteLine();

                                            lock (key)
                                            {
                                                int cont = 0;
                                                WaitQueue.ForEach(user => sw.WriteLine($"{(cont++) + 1,-2} | {user.Split(";")[0],-10} | {user.Split(";")[1]}"));

                                                if (WaitQueue.Count == 0)
                                                {
                                                    finalMessage = "La lista está vacía.";
                                                }
                                                else
                                                {
                                                    finalMessage = "Lista enviada.";
                                                }
                                            }

                                            sw.WriteLine();

                                            if (isAdmin == false)
                                            {
                                                stopClient = true;
                                            }
                                            else
                                            {
                                                sw.WriteLine(finalMessage);
                                            }

                                            break;
                                        case "del" when isAdmin == true && username == "admin":

                                            if (arg == null)
                                            {
                                                sw.WriteLine("Comando incorrecto [del <posicion>]");
                                            }
                                            else
                                            {
                                                if (WaitQueue.Count == 0)
                                                {
                                                    sw.WriteLine("No hay nadie en la lista de espera");

                                                }
                                                else
                                                {
                                                    bool parsetrigger = int.TryParse(arg, out int index);

                                                    if (index > WaitQueue.Count || index < 1)
                                                    {
                                                        sw.WriteLine("El índice esta fuera del rango de la lista");
                                                    }
                                                    else
                                                    {
                                                        if (parsetrigger)
                                                        {
                                                            lock (key)
                                                            {
                                                                WaitQueue.RemoveAt(index - 1);
                                                                sw.WriteLine("Usuario eliminado");
                                                            }
                                                        }
                                                        else
                                                        {
                                                            sw.WriteLine("Indice incorrecto");
                                                        }
                                                    }
                                                }
                                            }

                                            break;
                                        case "chpin" when isAdmin == true && username == "admin":

                                            if (string.IsNullOrEmpty(arg) || arg.Length > 4)
                                            {
                                                sw.WriteLine("La contraseña no puede estar vacía ni puede ser mayor a 4 dígitos");
                                            }
                                            else
                                            {
                                                using (StreamWriter fileWriter = new StreamWriter(passwordPath, false))
                                                {
                                                    try
                                                    {
                                                        fileWriter.WriteLine(arg);
                                                        sw.WriteLine("Contraseña actualizada");
                                                    }
                                                    catch (IOException ex)
                                                    {
                                                        sw.WriteLine(ex.Message);
                                                    }
                                                }
                                            }
                                            break;
                                        case "exit" when isAdmin == true && username == "admin":
                                            stopClient = true;
                                            finalMessage = "Saliendo del servidor";
                                            break;
                                        case "shutdown" when isAdmin == true && username == "admin":
                                            SaveQueueToJSON(JSONPath);
                                            finalMessage = "Apagando servidor";
                                            sClient.Close();
                                            MainSocket.Close();
                                            break;
                                    }
                                }
                            }
                            finally
                            {
                                sw.WriteLine(finalMessage);
                            }
                        }
                    }
                }
            }
            catch (IOException e)
            {
                Console.WriteLine($"El cliente cerró la conexión: {e.Message}");
            }
            catch (Exception e)
            {
                Console.WriteLine($"Error inesperado: {e.Message}");
            }
        }

        private void SaveQueueToJSON(string path)
        {
            using (StreamWriter sw = new StreamWriter(path))
            {
                try
                {
                    string json = JsonSerializer.Serialize(WaitQueue.ToArray(), new JsonSerializerOptions { WriteIndented = true });
                    sw.Write(json);
                }
                catch (IOException e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }

        private List<string> InitWaitQueue(string path)
        {
            using (StreamReader sr = new StreamReader(path))
            {
                try
                {
                    string jsonText = sr.ReadToEnd();
                    List<string> waitQueue = JsonSerializer.Deserialize<List<string>>(jsonText);

                    return waitQueue;
                }
                catch (IOException e)
                {
                    return null;
                }
            }
        }

        private void ReadNames(string filePath)
        {

            List<string> allUsers = new List<string>();

            using (StreamReader sr = new StreamReader(filePath))
            {
                try
                {
                    string line;

                    while ((line = sr.ReadLine()) != null)
                    {
                        lock (key)
                        {
                            allUsers.AddRange(line.Split(";"));
                        }
                    }

                    Users = allUsers.ToArray();
                }
                catch (IOException e)
                {
                    Console.WriteLine($"ERROR: {e.Message}");
                }
            }
        }

        private int ReadPin(string filePath)
        {
            using (StreamReader sr = new StreamReader(filePath))
            {
                try
                {
                    int password = 0;

                    string line = sr.ReadLine();
                    string nums = line.Substring(0, 4);
                    bool trigger = int.TryParse(nums, out int pins);

                    if (trigger)
                    {
                        password = pins;
                    }
                    else
                    {
                        Console.WriteLine("Error al convertir los valores a entero");
                    }

                    return password;
                }
                catch (IOException e)
                {
                    return -1;
                }
            }
        }
    }
}
