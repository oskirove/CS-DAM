using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio5.lib
{
    internal class Utils
    {
        public void addContactToFile(string name, int tel)
        {
            try
            {
                using (StreamWriter sw = new StreamWriter("../contactos.txt"))
                {
                    //sw.Write;
                }
            }
            catch (FileNotFoundException e)
            {
                Console.WriteLine($"No se ha encontrado el archivo: '{e}'");
            }
            catch (DirectoryNotFoundException e)
            {
                Console.WriteLine($"El directorio no existe: '{e}'");
            }
            catch (IOException e)
            {
                MessageBox.Show($"No se ha podido abrir el archivo: '{e}'");
            }
        }

    }
}
