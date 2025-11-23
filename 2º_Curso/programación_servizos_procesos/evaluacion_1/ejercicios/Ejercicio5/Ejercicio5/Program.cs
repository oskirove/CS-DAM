using static Ejercicio5.Utils;

namespace Ejercicio5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Utils u = new Utils();

            u.MenuGenerator(
                new string[] { "Op1", "Op2", "Op3" },
                new MyDelegate[] {
                    () => Console.WriteLine("A"),
                    () => Console.WriteLine("B"),
                    () => Console.WriteLine("C")
                }
            );
        }
    }
}
