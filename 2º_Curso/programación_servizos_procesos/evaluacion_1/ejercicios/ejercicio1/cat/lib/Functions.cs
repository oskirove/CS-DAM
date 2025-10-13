namespace cat.lib
{
    internal class Functions
    {
        public void ejecutarCat(String fichero)
        {
            Console.WriteLine(fichero);

            String line;
            StreamReader sr;
            sr = new StreamReader(fichero);//TODO using y control excepciones
            line = sr.ReadLine();

            while (line != null) {
                Console.WriteLine(line);
                line = sr.ReadLine();
            }
        }

        public void ejecutarCatLineas(String fichero, int lineas)
        {
            Console.WriteLine(fichero);

            String line;
            StreamReader sr;
            sr = new StreamReader(fichero);
            line = sr.ReadLine();
            int contador = 1;

            while (contador != lineas)//TODO llegada a final de archivo
            {
                contador++;
      
                Console.WriteLine(line);
                line = sr.ReadLine();
            }
        }
    }
}
