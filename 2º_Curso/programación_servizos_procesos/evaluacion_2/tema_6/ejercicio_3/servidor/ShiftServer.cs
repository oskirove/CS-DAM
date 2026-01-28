using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace servidor
{
    internal class ShiftServer
    {
        private string[] Users { get; set; }
        private List<string> WaitQueue { get; set; } = new List<string>();
        private bool ServerRunning { get; set; } = true;
        private int Port { get; set; } = 4321;
        private readonly object _key = new object();

        public void Init()
        {
            using (Socket s = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                bool trigger = false;
                IPEndPoint ie = null;

                while (!trigger && Port <= 65535 && Port > 1024)
                {
                    try
                    {
                        ie = new IPEndPoint(IPAddress.Any, Port);
                        s.Bind(ie);
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

                s.Listen(10);
                Console.WriteLine($"Servidor iniciado {ie.Address}:{Port}:");
                Console.WriteLine($"Esperando conexiones... (Ctrl+C para salir)");

                while (ServerRunning)
                {
                    Socket client = s.Accept();
                    Thread hilo = new Thread(() => ClientDispatcher(client));

                    hilo.Start();
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
                        sw.AutoFlush = true;
                        sw.WriteLine("------- LISTA DE ESPERA -------");
                        sw.Write("Introduce tu nombre de usuario: ");

                        string username = sr.ReadLine();

                        bool trigger = false;
                        string finalMessage = "Conexión terminada";
                        string command;
                        try
                        {
                            while (!trigger && (command = sr.ReadLine()) != null)
                            {
                                if (command == "add")
                                {
                                    WaitQueue.Add(username);
                                    finalMessage = "Usuario añadido en la lista, conexión finalizada";
                                    trigger = true;
                                }
                                else if (command == "list")
                                {
                                    WaitQueue.ForEach(user => sw.WriteLine(user));

                                    finalMessage = "Lista enviada, conexión finalizada";
                                    trigger = true;
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
            catch (IOException e)
            {
                Console.WriteLine($"El cliente cerró la conexión: {e.Message}");
            }
            catch (Exception e)
            {
                Console.WriteLine($"Error inesperado: {e.Message}");
            }
        }

        private void ReadNames(FileInfo filePath)
        {

            List<string> allUsers = new List<string>();

            try
            {
                using (StreamReader sr = new StreamReader(filePath.FullName))
                {
                    string line;

                    while ((line = sr.ReadLine()) != null)
                    {
                        lock (_key)
                        {
                            if ((line = sr.ReadLine()) != null)
                            {
                                allUsers.AddRange(line.Split(";"));
                            }
                        }
                    }

                    Users = allUsers.ToArray();
                }
            }
            catch (IOException e)
            {
                Console.WriteLine($"ERROR: {e.Message}");
            }
        }

        private int ReadPin(FileInfo filePath)
        {
            try
            {
                int password = 0;

                using (StreamReader sr = new StreamReader(filePath.FullName))
                {
                    string line = sr.ReadLine();
                    string nums = line.Substring(0, 3);
                    bool trigger = int.TryParse(nums, out int pins);

                    if (trigger)
                    {
                        password = pins;
                    }
                    else
                    {
                        Console.WriteLine("Error al convertir los valores a entero");
                    }
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
