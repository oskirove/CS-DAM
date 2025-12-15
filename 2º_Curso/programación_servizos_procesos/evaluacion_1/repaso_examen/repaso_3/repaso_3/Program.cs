using System.Runtime.CompilerServices;
using System.Text;

namespace repaso_3
{
    internal class Program
    {
        public static bool running = true;
        public static readonly object key = new object();

        public static void Correr(int x, int y)
        {

            StringBuilder pista = new StringBuilder();
            while (running)
            {
                        pista.Append(" ");
                lock (key)
                {
                    if (running)
                    {
                        Console.SetCursorPosition(x, y);
                        Console.Write(pista.ToString() + "*");
                    }
                }

                Thread.Sleep(200);
                //Thread.Sleep(new Random().Next(10, 100));
            }
        }

        static void Main(string[] args)
        {
            Thread[] caballos = new Thread[5];

            for (int i = 0; i < caballos.Length; i++)
            {
                caballos[i] = new Thread(() => Correr(1, i));
            }

            for (int i = 0; i < caballos.Length; i++)
            {
                caballos[i].Start(i);
            }
        }
    }
}
