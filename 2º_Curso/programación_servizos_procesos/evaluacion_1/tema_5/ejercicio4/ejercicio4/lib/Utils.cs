using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio4.lib
{
    internal class Utils : IDisposable
    {
        public async Task<string> BuscaPalabra(string ruta, string palabra)
        {
            int cont = 0;
            string fileName = null;
            DirectoryInfo dir = new DirectoryInfo(ruta);
            Dictionary<string, string> colArchivos = getArchivosTxt(dir);

            foreach (KeyValuePair<string, string> archivo in colArchivos)
            {
                try
                {
                    using (StreamReader lectura = new StreamReader(archivo.Value))
                    {
                        string line = lectura.ReadLine();
                    }

                }
                catch (FileNotFoundException e)
                {
                    Console.WriteLine($"El archivo no existe: '{e}'");
                }
                catch (DirectoryNotFoundException e)
                {
                    Console.WriteLine($"No se ha encontrado el directorio: '{e}'");
                }
                catch (IOException e)
                {
                    Console.WriteLine($"No se pudo abrir el archivo: '{e}'");
                }
            }

            return $"La palabra {palabra} ha aparecido {cont} en el archivo {fileName}";
        }

        public Dictionary<string, string> getArchivosTxt(DirectoryInfo directoryInfo)
        {
            FileInfo[] archivos = directoryInfo.GetFiles();
            Dictionary<string, string> nombreArchivosTxt = new Dictionary<string, string>();

            foreach (FileInfo archivo in archivos)
            {
                if (archivo.Name.EndsWith(".txt"))
                {
                    nombreArchivosTxt.Add(archivo.Name, archivo.FullName);
                }
            }

            return nombreArchivosTxt;
        }

        public void Dispose()
        {
            throw new NotImplementedException();
        }
    }
}
