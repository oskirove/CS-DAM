using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ejercicio_5
{
    internal class FlyServer
    {
        private Socket MainSocket;
        private bool ServerRunning = true;
        private List<FlyRunner> clients;

        public void InitServer()
        {
            using (MainSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                int port = GetPort();
                IPEndPoint ie = new IPEndPoint(IPAddress.Any, port);
                MainSocket.Bind(ie);
                MainSocket.Listen(10);

                Console.WriteLine();
                Console.WriteLine($"Servidor iniciado {ie.Address}:{port}:");
                Console.WriteLine($"Esperando conexiones... (Ctrl+C para salir)");

                while (ServerRunning)
                {
                    try
                    {
                        Socket client = MainSocket.Accept();
                        Thread hilo = new Thread(() => FlyRunnerThread(client));

                        hilo.Start();
                    }
                    catch (SocketException e)
                    {
                        ServerRunning = false;
                    }
                }
            }

        }

        private void FlyRunnerThread(Socket sClient)
        {
            try
            {
                using (sClient)
                {
                    using (NetworkStream ns = new NetworkStream(sClient))
                    using (StreamReader sr = new StreamReader(ns, Console.OutputEncoding))
                    using (StreamWriter sw = new StreamWriter(ns, Console.OutputEncoding))
                    {
                        sw.AutoFlush = true;
                        sw.WriteLine("Fly");

                        string message = sr.ReadLine();

                        while ((message = sr.ReadLine()) != null)
                        {
                            sw.WriteLine(message);
                        }
                    }
                }
            }
            catch (IOException e)
            {
                Console.WriteLine("Se cerró la conexión");
            }
        }

        private int GetPort()
        {
            string path = Path.Combine(Environment.GetEnvironmentVariable("USERPROFILE"), "data.bin");
            int mainPort, secondaryPort;

            try
            {
                using (FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read))
                using (BinaryReader br = new BinaryReader(fs))
                {
                    mainPort = br.ReadInt32();
                    secondaryPort = br.ReadInt32();

                    if (IsPortFree(mainPort))
                    {
                        return mainPort;
                    }
                    else if (IsPortFree(secondaryPort))
                    {
                        return secondaryPort;
                    }
                    else
                    {
                        return -1;
                    }
                }
            }
            catch (IOException)
            {
                CrearArchivoPuertos(path);
                return -1;
            }
        }

        private bool IsPortFree(int port)
        {
            using (Socket tempSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                try
                {
                    tempSocket.Bind(new IPEndPoint(IPAddress.Any, port));
                    return true;
                }
                catch (SocketException)
                {
                    return false;
                }
            }
        }

        private void CrearArchivoPuertos(string path)
        {
            try
            {
                using (FileStream fs = new FileStream(path, FileMode.Create, FileAccess.Write))
                using (BinaryWriter bw = new BinaryWriter(fs))
                {
                    bw.Write(135);
                    bw.Write(31416);

                    Random rnd = new Random();

                    for (int i = 0; i < 8; i++)
                    {
                        int puertoAleatorio = rnd.Next(1024, 65536);
                        bw.Write(puertoAleatorio);
                    }
                }
                Console.WriteLine("Archivo port.bin creado con valores por defecto.");
            }
            catch (IOException e)
            {
                Console.WriteLine($"Error al crear el archivo: {e.Message}");
            }
        }

        private void Broadcast()
        {

        }
    }
}
