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
        public string BuscaPalabra(DirectoryInfo ruta, string palabra)
        {
            int cont = 0;
            string fileName = null;
            List<string> palabras = new List<string>();
            Dictionary<string, string> colArchivos = getArchivosTxt(ruta);

            foreach (KeyValuePair<string, string> archivo in colArchivos)
            {
                try
                {
                    using (StreamReader lectura = new StreamReader(archivo.Value))
                    {
                        string linea;
                        while ((linea = lectura.ReadLine())!= null)
                        {
                            fileName = archivo.Key;

                            string[] palabrasLinea = linea.Split(' ');
                            foreach (string p in palabrasLinea)
                            {
                                palabras.Add(p);
                                if (palabras.Contains(palabra))
                                {
                                    cont++;
                                }
                            }
                        }
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
