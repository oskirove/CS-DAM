using System;
using System.Threading;

namespace repaso_1
{
    internal class Program
    {
        private static int NCebollas = 0;
        private static int NPatatas = 0;
        private static int NTortillas = 0;

        private static readonly object key = new object();

        public static void Tortilla()
        {
            while (NTortillas < 10)
            {
                lock (key)
                {
                    if (NTortillas < 10)
                    {
                        if (NPatatas >= 5 && NCebollas >= 5)
                        {
                            NPatatas -= 5;
                            NCebollas -= 5;
                            NTortillas++;

                            Console.ForegroundColor = ConsoleColor.Green;
                            Console.WriteLine("Patatas: {0,3} | Cebollas: {1,3} | Tortillas: {2,3}", NPatatas, NCebollas, NTortillas);
                            Console.ResetColor();
                        }
                    }
                }
            }
        }

        public static void Ingrediente(string ingrediente)
        {
            while (NTortillas < 10)
            {
                lock (key)
                {
                    if (NTortillas < 10)
                    {
                        if (ingrediente.Equals("cebolla"))
                        {
                            NCebollas++;
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Cebollas: " + NCebollas);
                            Console.ResetColor();
                        }
                        else
                        {
                            NPatatas++;
                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.WriteLine("Patatas: " + NPatatas);
                            Console.ResetColor();
                        }
                    }

                    if (new Random().NextDouble() < 0.5)
                    {
                        Thread.Sleep(50);
                    }
                }
            }

        }

        static void Main(string[] args)
        {
            Thread hiloCebollas = new Thread(() => Ingrediente("cebolla"));
            Thread hiloPatatas = new Thread(() => Ingrediente("patata"));
            Thread hiloTortillas = new Thread(Tortilla);

            hiloCebollas.Start();
            hiloPatatas.Start();
            hiloTortillas.Start();

            hiloTortillas.Join();

            Console.WriteLine("Han sobrado {0} patatas y {1} cebollas.", NPatatas, NCebollas);
        }
    }
}
