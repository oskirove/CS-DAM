using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio7.Clases
{
    internal class Cometa : Astro, ITerraformable
    {
        public Cometa(string nombre, double radio) : base(nombre, radio)
        {

        }
        public bool esHabitable()
        {
            return false;
        }
        public override string ToString()
        {
            return String.Format("{0,10} | {1,4} | {2:F2}", nombre, "None", radio);
        }
    }
}
