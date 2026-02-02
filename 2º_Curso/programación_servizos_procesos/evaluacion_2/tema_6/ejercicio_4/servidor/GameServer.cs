using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace servidor
{
    internal class GameServer
    {
        private Socket MainSocket;
        int Port { get; set; } = 4321;
        private bool ServerRunning { get; set; } = true;
        private readonly object key = new object();
        private readonly string WordsPath = $"{Environment.GetEnvironmentVariable("USERPROFILE")}/words.txt";
        private List<string> Words;

        public void InitServer()
        {
            using (MainSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                bool trigger = false;
                IPEndPoint ie = null;

                while (!trigger && Port <= 65535)
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
                            Console.WriteLine($"Error: Puerto {Port} ocupado, probando con el siguiente.");
                            Port++;
                        }
                    }
                }

                MainSocket.Listen(10);
                Console.WriteLine($"Servidor en escucha {ie.Address}:{Port}");
                Console.WriteLine($"Esperando conexiones... (Ctrl+c para salir)");

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
                    bool stopClient = false;
                    string message;

                    IPEndPoint ieClient = (IPEndPoint)sClient.RemoteEndPoint;
                    Console.WriteLine($"Cliente conectado: {ieClient.Address} en el puerto {ieClient.Port}");
                    Encoding encoding = Console.OutputEncoding;

                    Words = ReadWordsFile(WordsPath);

                    using (NetworkStream ns = new NetworkStream(sClient))
                    using (StreamReader sr = new StreamReader(ns, encoding))
                    using (StreamWriter sw = new StreamWriter(ns, encoding))
                    {
                        sw.AutoFlush = true;

                        sw.WriteLine("--------- JUEGO DEL AHORCADO ---------");

                        while (!stopClient && (message = sr.ReadLine()) != null)
                        {
                            switch (message)
                            {
                                case "gw":
                                    Random rand = new Random();
                                    int num = (int)rand.Next(0, Words.Count);
                                    break;
                                case "sw":

                                    break;
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

        private List<string> ReadWordsFile(string path)
        {
            List<String> words = new List<String>();

            try
            {
                using (StreamReader sr = new StreamReader(path))
                {
                    string line;
                    while ((line = sr.ReadLine()) != null)
                    {
                        words.AddRange(line.Split(",").Select(item => item.ToUpper()));
                    }
                }

                return words;
            }
            catch (IOException e)
            {
                return null;
            }
        }
    }
}
