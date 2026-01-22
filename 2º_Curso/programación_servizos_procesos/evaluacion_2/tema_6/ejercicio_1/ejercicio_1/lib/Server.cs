using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ejercicio_1.lib
{
    internal class Server//Cierre de servidor en close cerrando socket de escucha. IsBackground. 
    {
        public bool ServerRunning { set; get; } = true;
        public int Port { get; set; } = 4321;
        private Socket listener;

        public void InitServer()
        {
            bool trigger = false;
            IPEndPoint ie = null;

            using (Socket s = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {

                while (!trigger && Port < 65535)
                {
                    try
                    {
                        ie = new IPEndPoint(IPAddress.Any, Port);
                        s.Bind(ie);
                        trigger = true;
                    }
                    catch (SocketException ex)
                    {
                        if (ex.ErrorCode == 10048)
                        {
                            Console.WriteLine($"Puerto {Port} ocupado, probando el siguiente...");
                            Port++;
                        }
                    }
                }

                s.Listen(10);
                Console.WriteLine($"Servidor iniciado. " +
                $"Escuchando en {ie.Address}:{ie.Port}");
                Console.WriteLine("Esperando conexiones... (Ctrl+C para salir)");

                while (ServerRunning)
                {
                    Socket client = s.Accept();

                    Thread hilo = new Thread(() => ClientDispatcher(client));

                    hilo.IsBackground = true;
                    hilo.Start();
                }

                try
                {
                    if (!ServerRunning)
                    {
                        s.Shutdown(SocketShutdown.Both);
                        s.Close();
                    }
                }
                catch (SocketException ex)
                {
                    Console.WriteLine(ex.Message);
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
                        string[]? msg = null;

                        string line = sr.ReadLine();

                        if (line == null)
                        {
                            Console.WriteLine("Cliente desconectado");
                            return;
                        }

                        line = line.Trim();

                        msg = line.Split(" ");

                        if (msg.Length == 1)
                        {
                            switch (msg[0].ToLower())
                            {
                                case "time":
                                    sw.WriteLine($"Hora: {DateTime.Now.ToString("HH:mm:ss")}");
                                    break;

                                case "date":
                                    sw.WriteLine($"Fecha: {DateTime.Now.ToString("dd/MM/yyyy")}");
                                    break;

                                case "all":
                                    sw.WriteLine($"Fecha y hora: {DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss")}");
                                    break;
                                default:
                                    sw.WriteLine("Comando no reconocido");
                                    break;
                            }
                        }

                        if (line.StartsWith("close "))
                        {

                            string password = line.Substring(6);
                            if (password == (PasswordChecker()))
                            {
                                sw.WriteLine("Cerrando conexión...");
                                ServerRunning = false;
                            }
                            else
                            {
                                sw.WriteLine("Contraseña incorrecta");
                            }
                            sw.WriteLine(password);
                        }
                    }
                }
            }
            catch (IOException ex)
            {
                Console.WriteLine($"El cliente cerró la conexión: {ex.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error inesperado: {ex.Message}");
            }

        }

        private string PasswordChecker()
        {
            try
            {
                string password = null;
                string? programData = Environment.GetEnvironmentVariable("PROGRAMDATA");

                if (programData != null)
                {
                    string path = Path.Combine(programData, "password.txt");
                    using (StreamReader sr = new StreamReader(path))
                    {
                        password = sr.ReadLine().Trim();
                    }
                }
                return password;
            }
            catch (IOException e)
            {
                Console.WriteLine("No se ha podido leer el archivo." + e.Message);
                return null;
            }
        }
    }
}
