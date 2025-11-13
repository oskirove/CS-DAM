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
            int contador = 0;

            DirectoryInfo directoryInfo = new DirectoryInfo(ruta);
           
            List<string> archivosTxt = getArchivosTxt(directoryInfo);
            List<string> palabras = await guardarPalabrasArchivos(archivosTxt);

            if (!directoryInfo.Exists)
            {
                MessageBox.Show("El fichero al que intentas acceder no existe.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            for (int i = 0; i < palabras.Count; i++)
            {
                if (palabras[i].Equals(palabra))
                {
                    contador++;
                }
            }

            if (contador == 0)
            {
                MessageBox.Show("La palabra que buscas no se encuentra en los archivos de texto.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            string cadena = $"la palabra '{palabra}' aparece {contador} veces en el archivo '{directoryInfo.Name}'...";

            return cadena;
        }

        public List<string> getArchivosTxt(DirectoryInfo directoryInfo)
        {
            FileInfo[] archivos = directoryInfo.GetFiles();
            List<string> nombreArchivosTxt = new List<string>();

            foreach (FileInfo archivo in archivos)
            {
                if (archivo.Name.EndsWith(".txt"))
                {
                    nombreArchivosTxt.Add(archivo.FullName);
                }
            }

            return nombreArchivosTxt;
        }

        public async Task<List<string>> guardarPalabrasArchivos(List<string> archivos)
        {
            List<string> palabras = new List<string>();

            foreach (string archivo in archivos)
            {
                try
                {
                    using (StreamReader sr = new StreamReader(archivo))
                    {
                        string contenido = await sr.ReadToEndAsync();

                        string[] palabrasArchivo = contenido.ToLower().Split(new[] { ' ', '\n', '\r', '\t' }, StringSplitOptions.RemoveEmptyEntries);

                        palabras.AddRange(palabrasArchivo);
                    }
                }
                catch (FileNotFoundException e)
                {
                    MessageBox.Show($"El fichero no fue encontrado: '{e}'", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                catch (DirectoryNotFoundException e)
                {
                    MessageBox.Show($"El directorio no fue encontrado: '{e}'", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                catch (IOException e)
                {
                    MessageBox.Show($"No se ha podido abrir el fichero: '{e}'", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }

            return palabras;
        }

        public void Dispose()
        {
            throw new NotImplementedException();
        }
    }
}
