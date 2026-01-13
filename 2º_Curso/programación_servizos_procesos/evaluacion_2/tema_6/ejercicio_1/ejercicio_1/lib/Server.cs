using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ejercicio_1.lib
{
    internal class Server
    {
        public static void init()
        {
            int port = 4321;
            IPEndPoint ie = new IPEndPoint(IPAddress.Any, port);

            using (Socket s = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                try
                {
                    s.Bind(ie);
                    s.Listen(10);

                    Console.WriteLine($"Servidor iniciado. Escuchando en {ie.Address}:{ie.Port}");
                    Console.WriteLine($"Esperando conexiones");

                    Socket sClient = s.Accept();

                    using (sClient) 
                    {
                        IPEndPoint ieClient = (IPEndPoint)sClient.RemoteEndPoint;
                        Console.WriteLine($"Cliente conectado: {ieClient.Address} en puerto {ieClient.Port}");

                        using (NetworkStream ns = new NetworkStream(sClient))
                        using (StreamReader sr = new StreamReader(ns))
                        using (StreamWriter sw = new StreamWriter(ns))
                        {
                            string welcome = "Welcome to The Echo-Logic, Odd, Desiderable, " +
                            "Incredible, and Javaless Echo Server (T.E.L.O.D.I.J.E Server)";
                            // El envío por red se convierte en un WriteLine
                            sw.WriteLine(welcome);
                            // Con flush se fuerza el envío de los datos sin esperar al cierre
                            // Otra opción es: sw.AutoFlush = true
                            sw.Flush();
                            // Esperamos a la recepción del mensaje
                            // El ReadLine es bloqueante.
                            // Más adelante veremos comprobaciones sobre lo recibido.
                            string msg = sr.ReadLine();
                            // Se muestra por consola lo que manda el cliente
                            if (msg != null)
                            {
                                Console.WriteLine(msg);
                            }
                            else
                            {
                                Console.WriteLine("El cliente cerró la conexión.");
                            }
                            // Finalización de la conexión
                        }
                    }
                }
                catch (SocketException e) when (e.ErrorCode == (int)SocketError.AddressAlreadyInUse)
                {
                    Console.WriteLine($"Puerto {port} en uso");
                }
                catch (SocketException e)
                {
                    Console.WriteLine($"Error: {e.SocketErrorCode} - {e.Message}");
                }
            }
        }
    }
}
