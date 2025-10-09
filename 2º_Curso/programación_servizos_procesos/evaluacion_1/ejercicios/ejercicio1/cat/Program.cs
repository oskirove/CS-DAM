using cat.lib;
using System.IO;
using System.Linq.Expressions;

namespace cat
{
    internal class Program
    {
        public static string COLOR_ERROR = "\u001b[1;31m";
        public static string CIERRE = "\u001b[0m";

        static void Main(string[] args)
        {
            args = new string[] { "cat","-n5", "cat.exe"};

            Functions f = new Functions();

            if (args.Length == 0)
            {
                Console.WriteLine(COLOR_ERROR + "No se ha pasado ningun argumento" + CIERRE);
            }

            if (args.Length > 3)
            {
                Console.WriteLine(COLOR_ERROR + "Exceso de argumentos" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: cat myfile.txt" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: cat -n<Número de lineas> myfile.txt" + CIERRE);
            }

            switch (args.Length)
            {
                case 3:
                    if (args[0] != "cat")
                    {
                        Console.WriteLine(COLOR_ERROR + "El primer argumento no es válido" + CIERRE);
                    }

                    if (args[1] != "-n")
                    {
                        Console.WriteLine(COLOR_ERROR + "Argumento de lineas no válido" + CIERRE);
                    }

                    String file = args[2].Trim();
                    String path = Environment.CurrentDirectory + "\\" + file;

                    if (!File.Exists(path))
                    {
                        Console.WriteLine(COLOR_ERROR + "El fichero no existe" + CIERRE);
                    }

                    f.ejecutarCatLineas(path, 4);
                    break;

                case 2:
                    if (args[0] != "cat")
                    {
                        Console.WriteLine(COLOR_ERROR + "El primer argumento no es válido" + CIERRE);
                    }

                    String file1 = args[1].Trim();
                    String path1 = Environment.CurrentDirectory + "\\" + file1;

                    if (!File.Exists(path1))
                    {
                        Console.WriteLine(COLOR_ERROR + "El fichero no existe" + CIERRE);
                    }

                    f.ejecutarCat(path1);
                    break;
            }
        }
    }
}
