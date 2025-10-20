namespace Ejercicio7.lib
{
    internal class Functions
    {
        public static int solicitarEntero(string message)
        {
            while (true)
            {
                Console.Write(message);
                string opcion = Console.ReadLine().Trim();

                if (string.IsNullOrEmpty(opcion))
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("El campo no puede estar vacío.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                bool trigger = int.TryParse(opcion, out int conversion);

                if (!trigger)
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("No puedes introducir letras ni caracteres especiales");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                return conversion;
            }
        }

        public static double solicitarReal(string message)
        {
            while (true)
            {
                Console.Write(message);
                string opcion = Console.ReadLine().Trim();

                if (string.IsNullOrEmpty(opcion))
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("El campo no puede estar vacío.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                bool trigger = double.TryParse(opcion, out double conversion);

                if (!trigger)
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("No puedes introducir letras ni caracteres especiales");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                return conversion;
            }
        }

        public static string solicitarCadena(string message)
        {

            while (true)
            {
                Console.Write(message);

                string cadena = Console.ReadLine().Trim();

                if (string.IsNullOrEmpty(cadena))
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("El campo no puede estar vacío.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                return cadena;
            }
        }

        public static bool preguntarGaseoso(string message)
        {
            while (true)
            {
                Console.Write(message);

                string cadena = Console.ReadLine().Trim().ToLower();

                if (string.IsNullOrEmpty(cadena))
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("El campo no puede estar vacío.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                if (cadena != "y" && cadena != "n")
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("Debes escribir Y o N.");
                    Console.WriteLine();
                    Console.ResetColor();
                    continue;
                }

                return cadena == "y";
            }
        }
    }
}
