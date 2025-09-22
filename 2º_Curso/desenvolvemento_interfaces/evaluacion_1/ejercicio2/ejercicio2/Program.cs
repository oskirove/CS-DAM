namespace ejercicio2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Introduce tu nombre: ");
            string nombre = Console.ReadLine();

            Console.Write("Introduce tu edad: ");
            int edad = int.Parse(Console.ReadLine());

            Console.Write("Introduce tu peso: ");
            double peso = double.Parse(Console.ReadLine());

            Console.WriteLine("{0,-12}{1,4}\n\t{2,5:F1}\n\"{0}\" \\{1}\\", nombre, edad, peso);

        }
    }
}
