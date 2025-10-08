using ls.lib;

namespace ejercicio1
{
    internal class Program
    {
        public static string COLOR_ERROR = "\u001b[1;31m";
        public static string CIERRE = "\u001b[0m";

        static int Main(string[] args)
        {

            args = new string[] { "ls", "c:\\temp" };

            if (args.Length == 0)
            {
                Console.WriteLine(COLOR_ERROR + "No se ha pasado ningun argumento" + CIERRE);
                return 3;
            }
            else if (args[0] != "ls")
            {
                Console.WriteLine(COLOR_ERROR + "Argumento no válido" + CIERRE);

                return 2;
            }
            else if (args.Length > 2)
            {

                Console.WriteLine(COLOR_ERROR + "Exceso de argumentos" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: ls %appdata%" + CIERRE);

                return 1;
            }
            else
            {

                String path = null;

                if (args[1].Contains('%'))
                {
                    args[1] = args[1].Replace("%", "");
                    path = Environment.GetEnvironmentVariable(args[1]);
                } else if (args[1].StartsWith("c:\\") || args[1].StartsWith("C:\\"))
                {
                    String ruta = Environment.GetEnvironmentVariable("SYSTEMROOT");
                    path = ruta + args[1].Substring(2).Trim();
                }
                else if (args[1].StartsWith(Environment.GetEnvironmentVariable("HOMEPATH")))
                {
                    path = args[1];
                }

                Functions f = new Functions();
                f.ejecutarLs(path);

                return 0;
            }
        }
    }
}
