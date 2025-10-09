using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cat.lib
{
    internal class Functions
    {
        public void ejecutarCat(String fichero)
        {
            Console.WriteLine(fichero);

            String line;
            StreamReader sr;
            sr = new StreamReader(fichero);
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

            while (contador != lineas)
            {
                contador++;
      
                Console.WriteLine(line);
                line = sr.ReadLine();
            }
        }
    }
}
