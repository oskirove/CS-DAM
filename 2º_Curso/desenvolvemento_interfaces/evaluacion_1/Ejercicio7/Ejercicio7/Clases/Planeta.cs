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

        public Planeta(String nombre, double radio, bool gaseoso, int numSatelites) : base(nombre, radio)
        {
            this.gaseoso = gaseoso;
            this.numSatelites = numSatelites;
        }

        public Planeta() : this("", 1, false, 0)
        {

        }

        public void setGaseoso(bool gaseoso)
        {
            this.gaseoso = gaseoso;
        }

        public bool getGaseoso()
        {
            return this.gaseoso;
        }

        public bool esHabitable()
        {
            return getGaseoso() == false && radio > 2000 && radio < 8000;
        }

        public override string ToString()
        {
            return base.ToString();
        }

    }
}
