using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace Ejercicio5.lib
{
    internal class Utils
    {
        public void addContactToFile(string name, string tel)
        {
            try
            {
                using (StreamWriter sw = new StreamWriter("C:\\Users\\oscar\\source\\repos\\CS-DAM\\2º_Curso\\desenvolvemento_interfaces\\evaluacion_1\\Tema4\\Ejercicio5\\Ejercicio5\\contactos.txt", append: true))
                {
                    sw.WriteLine($"{name}:{tel}");
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

        public List<string> getContactsFromFile()
        {
            {
                List<string> contactos = new List<string>();

                try
                {
                    using (StreamReader sr = new StreamReader("C:\\Users\\oscar\\source\\repos\\CS-DAM\\2º_Curso\\desenvolvemento_interfaces\\evaluacion_1\\Tema4\\Ejercicio5\\Ejercicio5\\contactos.txt"))
                    {
                        string line;
                        while ((line = sr.ReadLine()) != null)
                        {
                            contactos.Add(line);
                        }
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

                return contactos;
            }
        }

    }
}
