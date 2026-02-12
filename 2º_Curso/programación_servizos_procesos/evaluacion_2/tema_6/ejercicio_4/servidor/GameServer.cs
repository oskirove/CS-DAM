using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Xml.Linq;

namespace servidor
{
    internal class GameServer
    {
        private Socket MainSocket;
        int Port { get; set; } = 4321;
        private bool ServerRunning { get; set; } = true;
        private readonly object key = new object();
        private readonly FileInfo WordsFile = new FileInfo($"{Environment.GetEnvironmentVariable("USERPROFILE")}/words.txt");
        private readonly FileInfo RecordsFile = new FileInfo($"{Environment.GetEnvironmentVariable("USERPROFILE")}/records.bin");
        private List<string> Words;
        private List<Record> Records;

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
                    string username = null;
                    string command;
                    int time = 0;
                    System.Timers.Timer timer = new System.Timers.Timer(1000);

                    timer.Elapsed += (s, e) =>
                    {
                        time++;
                    };

                    IPEndPoint ieClient = (IPEndPoint)sClient.RemoteEndPoint;
                    Console.WriteLine($"Cliente conectado: {ieClient.Address} en el puerto {ieClient.Port}");
                    Encoding encoding = Console.OutputEncoding;

                    Words = ReadWordsFile();

                    using (NetworkStream ns = new NetworkStream(sClient))
                    using (StreamReader sr = new StreamReader(ns, encoding))
                    using (StreamWriter sw = new StreamWriter(ns, encoding))
                    {
                        sw.AutoFlush = true;

                        timer.Start();

                        while (!stopClient && (command = sr.ReadLine()) != null)
                        {
                            string[] parts = command.Split(" ", 2);
                            string cmd = parts[0];
                            string arg = parts.Length > 1 ? parts[1] : null;

                            switch (cmd)
                            {
                                case "gw":

                                    Random rand = new Random();
                                    int num = (int)rand.Next(0, Words.Count);

                                    sw.WriteLine(Words[num]);

                                    break;
                                case "sw":

                                    if (!string.IsNullOrEmpty(arg))
                                    {
                                        if (Words.Contains(arg))
                                        {
                                            sw.WriteLine("Esta palabra ya existe en el archivo.");
                                        }
                                        else
                                        {
                                            lock (key)
                                            {
                                                Words.Add(arg);
                                                saveWord(arg);
                                            }

                                            sw.WriteLine($"Se ha añadido {arg} al archivo.");
                                        }
                                    }
                                    else
                                    {
                                        sw.WriteLine("Comando incorrecto.");
                                        sw.WriteLine("Uso: sw <palabra>");
                                    }

                                    break;
                                case "gr":
                                    Records = getRecords();
                                    foreach (Record r in Records)
                                    {
                                        sw.WriteLine($"{r.User} -> {r.Seconds}");
                                    }
                                    break;
                                case "sr":

                                    Record record = new Record(username, time);

                                    lock (key)
                                    {
                                        saveRecord(record);
                                        Records.Add(record);
                                    }

                                    break;
                                case "close":

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

        private List<string> ReadWordsFile()
        {
            List<string> words = new List<string>();

            try
            {
                using (StreamReader sr = new StreamReader(WordsFile.FullName))
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

        private List<Record> getRecords()
        {
            List<Record> records = new List<Record>();
            try
            {
                using (FileStream fs = new FileStream(RecordsFile.FullName, FileMode.Open, FileAccess.Read))
                using (BinaryReader br = new BinaryReader(fs))
                {
                    while (fs.Position < fs.Length)
                    {
                        string user = br.ReadString();
                        int time = br.ReadInt32();

                        records.Add(new Record(user, time));
                    }
                }
                return records;
            }
            catch (IOException e)
            {
                return null;
            }
        }

        private void saveWord(string word)
        {
            try
            {
                using (StreamWriter sw = new StreamWriter(WordsFile.FullName, true))
                {
                    sw.Write($",{word}");
                }
            }
            catch (IOException e)
            {
                Console.WriteLine("Error: no se pudo abrir el archivo");
            }
        }

        private void saveRecord(Record record)
        {
            try
            {
                using (FileStream stream = new FileStream(RecordsFile.FullName, FileMode.Append))
                using (BinaryWriter bw = new BinaryWriter(stream))
                {
                    bw.Write(record.User);
                    bw.Write(record.Seconds);
                }
            }
            catch (IOException e)
            {
                Console.WriteLine("Error: no se pudo abrir el archivo");
            }
        }
    }
}
