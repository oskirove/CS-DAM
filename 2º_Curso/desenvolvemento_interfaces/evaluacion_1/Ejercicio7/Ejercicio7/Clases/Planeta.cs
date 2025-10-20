using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio7.Clases
{
    internal class Planeta : Astro, ITerraformable
    {
        private bool gaseoso;
        public int numSatelites;

        public Planeta(string nombre, double radio, bool gaseoso, int numSatelites) : base(nombre, radio)
        {
            this.gaseoso = gaseoso;
            this.numSatelites = numSatelites;
        }

        public Planeta() : this("", 1, false, 0)
        {

        }

        public static Planeta operator ++(Planeta p)
        {
            p.numSatelites++;
            return p;
        }

        public static Planeta operator --(Planeta p)
        {
            if (p.numSatelites > 0)
                p.numSatelites--;
            return p;
        }

        public void setNumSatelites(int numSatelites)
        {
            this.numSatelites = numSatelites;
        }

        public int getNumSatelites()
        {
            return numSatelites;
        }

        public void setGaseoso(bool gaseoso)
        {
            this.gaseoso = gaseoso;
        }

        public bool getGaseoso()
        {
            return gaseoso;
        }

        public bool esHabitable()
        {
            return getGaseoso() == false && radio > 2000 && radio < 8000;
        }

        public override string ToString()
        {
            return String.Format("{0,10} | {1,4} | {2:F2}", nombre, numSatelites, radio);
        }
    }
}
