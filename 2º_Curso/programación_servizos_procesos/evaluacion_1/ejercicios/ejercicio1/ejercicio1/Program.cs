
namespace ejercicio1
{
    internal class Program
    {
        public static string COLOR_VERDE = "\u001b[1;32m";
        public static string COLOR_ERROR = "\u001b[1;31m";
        public static string COLOR_CYAN = "\u001b[1;36m";
        public static string COLOR_PURPURA = "\u001b[1;35m";
        public static string COLOR_AZUL = "\u001b[1;34m";
        public static string CIERRE = "\u001b[0m";
        static int Main(string[] args)
        {

            args = new string[] {"ls", "%appdata%"};

            if (args.Length == 0)
            {
                Console.WriteLine(COLOR_ERROR + "No se ha pasado ningun argumento" + CIERRE);
                return 3;
            } else if (args[0] != "ls")
            {
                Console.WriteLine(COLOR_ERROR + "Argumento no válido" + CIERRE);

                return 2;
            } else if (args.Length > 2)
            {

                Console.WriteLine(COLOR_ERROR + "Exceso de argumentos" + CIERRE);
                Console.WriteLine(COLOR_ERROR + "Ejemplo de uso: ls %appdata%" + CIERRE);

                return 1;
            } else
            {
                string path = Environment.GetEnvironmentVariable("PATH");
                String fichero = args[1];

                Console.WriteLine(path);
                return 0;
            }
        }
    }
}
