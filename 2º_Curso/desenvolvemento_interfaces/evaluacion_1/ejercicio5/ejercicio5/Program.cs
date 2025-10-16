using System.CodeDom.Compiler;

namespace ejercicio5
{
    internal class Program
    {

        public static bool calculoFactorial(ref int value)
        {
            if (value < 0 || value > 10) return false;

            int acum = 1;

            for (int i = value; i >= 1; i--)
            {
                acum *= i;
            }

            return true;
        }

        public static void posicionesAleatorias(int? cantidad = null)
        {
            int total = cantidad ?? 10;
            Random rand = new Random();

            for (int i = 0; i < total; i++)
            {
                int x = rand.Next(1, 21);
                int y = rand.Next(1, 11);

                Console.SetCursorPosition(x, y);
                Console.Write("*");
            }

            Console.SetCursorPosition(0, 11);
        }

        static void Main(string[] args)
        {

            int num = 5;

            posicionesAleatorias(12);

            Console.ReadKey();
        }
    }
}
