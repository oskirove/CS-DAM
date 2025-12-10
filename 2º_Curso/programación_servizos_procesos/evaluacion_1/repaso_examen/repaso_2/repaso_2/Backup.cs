using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_2
{
    internal class Backup
    {
        private List<string> log = new List<string>();

        public List<string> Log
        {
            get { return log; }
            set { log = value; }
        }

        public FileInfo[] BuscaArchivos(DirectoryInfo dir, string[] extensiones)
        {
            List<FileInfo> ficherosValidos = new List<FileInfo>();

            if (dir.Exists)
            {
                FileInfo[] totalFicheros = dir.GetFiles();

                for (int i = 0; i < totalFicheros.Length; i++)
                {
                    Array.ForEach(extensiones, extension =>
                    {
                        if (totalFicheros[i].FullName.EndsWith(extension))
                        {
                            ficherosValidos.Add(totalFicheros[i]);
                        }
                    });
                }

                return ficherosValidos.ToArray();
            }
            else
            {
                return null;
            }
        }

        public bool CopiaArchivo(FileInfo archivo, string dirDestino)
        {
            try
            {
                int cont = 0;

                string destinoArchivo = Path.Combine(dirDestino, archivo.Name);

                using (StreamReader sr = new StreamReader(archivo.FullName))
                using (StreamWriter sw = new StreamWriter(destinoArchivo, false))
                {
                    string? line;

                    while ((line = sr.ReadLine()) != null)
                    {
                        cont++;

                        sw.WriteLine(line);

                        if (cont % 10 == 0)
                        {
                            string log = string.Format("Archivo: {0,20} | Tamaño: {1,10}Bytes | Lineas: {2,5}", archivo.Name, archivo.Length, cont);
                            this.log.Add(log);
                        }
                    }
                }

                return true;
            }
            catch
            {
                return false;
            }
        }

        public int BuscaYCopia(DirectoryInfo dirOrigen, DirectoryInfo dirDestino, string[] extensiones)
        {
            int archivosCopiados = 0;
            FileInfo[] archivos = BuscaArchivos(dirOrigen, extensiones);

            Array.ForEach(archivos, archivo =>
            {
                if (CopiaArchivo(archivo, dirDestino.FullName))
                {
                    archivosCopiados++;
                }
            });

            return archivosCopiados;
        }

        public async Task<int> InitBackup(DirectoryInfo dirOrigen)
        {
            DirectoryInfo dirDestino = new DirectoryInfo(Environment.GetEnvironmentVariable("USERPROFILE") + "\\backup");

            Task<int> tarea1 = Task.Run(() => BuscaYCopia(dirOrigen, dirDestino, new string[] { ".txt", ".md", ".json" }));
            Task<int> tarea2 = Task.Run(() => BuscaYCopia(dirOrigen, dirDestino, new string[] { ".java", ".cs", ".py" }));

            int[] tareas = await Task.WhenAll(tarea1, tarea2);

            return tareas[0] + tareas[1];
        }
    }
}
