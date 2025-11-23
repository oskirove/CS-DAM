namespace ejercicio4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] notas = { 5, 2, 8, 1, 9, 4 };
            string[] palabras = { "Sol", "Luna", "Estrella", "Cielo" };

            if (notas.Any(nota => nota >= 5))
            {
                Console.WriteLine("Hay aprobados");
            }
            else
            {
                Console.WriteLine("No hay aprobados");
            }

            foreach (int nota in notas.Where(n => n >= 5))
            {
                Console.Write(nota + ", ");
            }

            Console.WriteLine();
            Console.WriteLine("Índice del último aprobado: " + Array.FindLastIndex(notas, nota => nota >=5 ));

            Console.WriteLine("El utlimo aprobado es: " + Array.FindLast(notas, nota => nota >= 5));

            int[] notasPares = (Array.FindAll(notas, nota => nota % 2 == 0));

            Console.WriteLine("La cantidad de notas pares es de: " + notasPares.Length);

            Console.WriteLine();

            // Segunda parte

            Console.WriteLine(Array.Find(palabras, palabra => palabra.Length > 3));

            Console.WriteLine();

            Array.ForEach(palabras, palabra => Console.WriteLine(palabra.ToUpper()));

            Console.WriteLine();
            Console.WriteLine(Array.FindIndex(palabras, palabra => palabra.StartsWith("E")));
        }
    }
}
