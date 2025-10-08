using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ls.lib
{
    
    internal class Functions
    {
        public static string COLOR_VERDE = "\u001b[1;32m";
        public static string COLOR_ERROR = "\u001b[1;31m";
        public static string COLOR_CYAN = "\u001b[1;36m";
        public static string COLOR_PURPURA = "\u001b[1;35m";
        public static string COLOR_AZUL = "\u001b[1;34m";
        public static string CIERRE = "\u001b[0m";
        public void ejecutarLs(String path)
        {
            if (Directory.Exists(path))
            {
                Console.WriteLine(COLOR_AZUL + "Ruta: " + path + CIERRE);
                Console.WriteLine();
                DirectoryInfo directory = new DirectoryInfo(path);

                DirectoryInfo[] listaDirectorios = directory.GetDirectories();
                FileInfo[] listaFicheros = directory.GetFiles();


                for (int i = 0; i < listaDirectorios.Length; i++)
                {
                    Console.WriteLine(COLOR_VERDE + "DIR: " + listaDirectorios[i].Name + CIERRE);
                }

                for (int i = 0; i < listaFicheros.Length; i++)
                {
                    Console.WriteLine(COLOR_PURPURA + "FILE: " + listaFicheros[i].Name + CIERRE);
                }
            }
            else
            {
                Console.WriteLine(COLOR_ERROR + "El directorio no existe." + CIERRE);
            }
        }
    }
}
