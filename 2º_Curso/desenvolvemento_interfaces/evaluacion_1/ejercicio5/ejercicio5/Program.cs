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

        public static posicionesAleatorias(int cantidad)
        {

        }
        static void Main(string[] args)
        {

            int num = 5;

            Console.WriteLine(calculoFactorial(ref num));

            Console.WriteLine("Hola mundo");

            Console.ReadKey();
        }
    }
}
