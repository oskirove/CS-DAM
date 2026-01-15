using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ejercicio_1.lib
{
    internal class Server
    {
        public bool ServerRunning { set; get; } = true;
        public int Port { get; set; } = 4321;

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

                    hilo.Start();
                }
            }
        }

        private void ClientDispatcher(Socket sClient)
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
                    sw.WriteLine("Servidor de tiempo");
                    string[]? msg = null;

                    string line = sr.ReadLine().Trim();

                    if (line == null)
                    {
                        sw.WriteLine("Error: comando vacío");
                    }

                    msg = line.Split(" ");

                    if (msg.Length > 3)
                    {
                        sw.WriteLine("Error: Demasiados argumentos en el comando");
                    }

                    if (msg.Length == 1)
                    {
                        switch (msg[0].ToLower())
                        {
                            case "time":
                                sw.WriteLine(DateTime.Now.ToString("HH:mm:ss"));
                                break;

                            case "date":
                                sw.WriteLine(DateTime.Now.ToString("dd/MM/yyyy"));
                                break;

                            case "all":
                                sw.WriteLine(DateTime.Now.ToString("dd/MM/yyyy HH:mm:ss"));
                                break;
                            default:
                                sw.WriteLine("Comando no reconocido");
                                break;
                        }
                    }
                    else if (msg.Length == 2)
                    {

                        if (msg[0].ToLower().Equals("close") && msg[1].Equals(PasswordChecker()))
                        {
                            sw.WriteLine("Cerrando conexión...");
                        }
                        else
                        {
                            sw.WriteLine("Contraseña incorrecta");
                        }
                    }
                }
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
