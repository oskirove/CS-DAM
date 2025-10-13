using cat.lib;

namespace cat
{
    internal class Program
    {
        public static string COLOR_ERROR = "\u001b[1;31m";
        public static string CIERRE = "\u001b[0m";

        static void Main(string[] args)
        {
            //C:\\Users\\oscar\\Downloads\\texto.txt
            args = new string[] { "cat", "-n10", "cat.exe" };

            Functions f = new Functions();

            if (args.Length == 0)
            {
                Console.WriteLine(COLOR_ERROR + "No se ha pasado ningun argumento" + CIERRE);
            }

            if (args.Length > 3)
            {
                Console.WriteLine(COLOR_ERROR + "Exceso de argumentos" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: cat myfile.txt" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: cat -n<lineas> myfile.txt" + CIERRE);
            }

            switch (args.Length)
            {
                case 3:
                    if (args[0] != "cat")
                    {
                        Console.WriteLine(COLOR_ERROR + "El primer argumento no es válido" + CIERRE);
                    }

                    if (!args[1].StartsWith("-n"))
                    {
                        Console.WriteLine(COLOR_ERROR + "Argumento de lineas no válido" + CIERRE);
                    }

                    String file = args[2];//.Trim();

                    String path = file;

                    //if (args[2].StartsWith("C:\\"))
                    //{
                    //    path = args[2];
                    //}
                    //else
                    //{
                    //    path = Environment.CurrentDirectory + "\\" + file;
                    //}

                    if (!File.Exists(path))
                    {
                        Console.WriteLine(COLOR_ERROR + "El fichero no existe" + CIERRE);
                    }

                    String lineas = args[1].Remove(0, 2);

                    int.TryParse(lineas, out int conversionLineas);

                    f.ejecutarCatLineas(path, conversionLineas);
                    break;

                case 2:
                    if (args[0] != "cat")
                    {
                        Console.WriteLine(COLOR_ERROR + "El primer argumento no es válido" + CIERRE);
                    }

                    String file1 = args[1].Trim();
                    String path1 = null;

                    if (args[1].StartsWith("C:\\"))
                    {
                        path1 = args[1];
                    }
                    else
                    {
                        path1 = Environment.CurrentDirectory + "\\" + file1;
                    }

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
