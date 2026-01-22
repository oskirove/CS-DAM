using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Runtime.CompilerServices;
using System.Text;

namespace ejercicio_2.lib
{
    internal class ChatServer
    {
        public bool ServerRunning { get; set; } = true;
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
                            Console.WriteLine($"Error: Puerto {Port} ocupado, probando con el siguiente... ");
                            Port++;
                        }
                    }
                }

                s.Listen(10);
                Console.WriteLine($"Servidor iniciado {ie.Address}:{ie.Port}");
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
            try
            {
                using(sClient)
                {
                    IPEndPoint ieClient = (IPEndPoint)sClient.RemoteEndPoint;
                    Console.WriteLine($"Cliente conectado: {ieClient.Address} en puerto {ieClient.Port}");
                    Encoding cod = Console.OutputEncoding;

                    using (NetworkStream ns = new NetworkStream(sClient))
                    using (StreamReader sr = new StreamReader(ns, cod))
                    using (StreamWriter sw = new StreamWriter(ns, cod))
                    {
                        String welcomeMessage = "----- CHAT ROOM -----";
                        sw.WriteLine(welcomeMessage);
                        sw.AutoFlush = true;

                        String message = sr.ReadLine();
                    }
                }
            }
            catch (IOException ex)
            {
                Console.WriteLine($"El cliente cerro la conexión: {ex.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error inesperado: {ex.Message}");
            }
        }
    }
}
