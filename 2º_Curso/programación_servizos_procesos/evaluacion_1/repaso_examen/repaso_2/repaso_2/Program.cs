namespace repaso_2
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            Backup b = new Backup();
            DirectoryInfo dir = new DirectoryInfo("C:\\Users\\oscar\\Downloads");

            int total = await b.InitBackup(dir);
            Console.WriteLine($"Total de archivos copiados: {total}");

            foreach (string entrada in b.Log)
            {
                Console.WriteLine(entrada);
            }
        }
    }
}
