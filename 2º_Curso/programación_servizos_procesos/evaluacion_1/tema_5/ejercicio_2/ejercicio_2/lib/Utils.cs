using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio_2.lib
{
    internal class Utils
    {
        static bool running = true;
        static readonly object l = new object();

        public static int solicitarEntero(string mensaje)
        {
            while (true)
            {
                Console.Write(mensaje);
                string input = Console.ReadLine();

                if (!int.TryParse(input, out int apuesta))
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine();
                    Console.WriteLine("ERROR: Lo que has introducido no es un número.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                if (apuesta < 1 || apuesta > 5)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine();
                    Console.WriteLine("ERROR: Son 5 caballos, por lo que debes introducir un número entre 1 y 5 incluidos.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                return apuesta;
            }
        }

        public Thread inicializarCaballos(int apuesta)
        {
            Thread[] caballos = new Thread[5];

            for (int i = 0; i < caballos.Length; i++)
            {
                int id = i;
                caballos[i] = new Thread(correr);
                caballos[i].Start(id);
                Console.WriteLine();
            }

            return caballos[apuesta - 1];
        }

        public void correr(object obj)
        {
            int id = (int)obj;
            StringBuilder pista = new StringBuilder();

            while (true)
            {
                lock (l)
                {
                    if (!running) break;

                    pista.Append(' ');
                    Console.SetCursorPosition(0, id);
                    Console.Write(pista.ToString() + "*");
            
                    int randomSleep = new Random().Next(10, 1000);
                    Thread.Sleep(randomSleep);

                    if (pista.Length >= 20)
                    {
                        running = false;
                    }
                }
            }
            Console.Clear();
        }
    }
}
