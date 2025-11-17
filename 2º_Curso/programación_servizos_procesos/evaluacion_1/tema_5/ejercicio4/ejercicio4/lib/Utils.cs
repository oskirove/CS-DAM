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



            return null;
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
