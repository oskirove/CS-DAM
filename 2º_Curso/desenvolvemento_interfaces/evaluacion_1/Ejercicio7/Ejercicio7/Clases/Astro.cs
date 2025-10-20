using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio7.Clases
{
    internal abstract class Astro
    {
        protected string nombre;
        protected double radio;

        public Astro(string nombre, double radio)
        {
            this.nombre = nombre;
            this.radio = radio;
        }

        public Astro()
        {
            nombre = "Tierra";
            radio = 6378;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre.ToUpper();
        }

        public string getNombre()
        {
            return $"\"{nombre}\"";
        }

        public void setRadio(double radio)
        {
            if (radio < 0)
            {
                throw new ArgumentException("El radio no puede ser menor que cero");
            }

            this.radio = radio;
        }

        public double getRadio()
        {
            return radio;
        }

        public override bool Equals(object? obj)
        {
            if (obj is string nombrestring)
            {
                return nombre.Equals(nombrestring, StringComparison.OrdinalIgnoreCase);
            }

            if (obj is Astro otroAstro)
            {
                return nombre.Equals(otroAstro.nombre, StringComparison.OrdinalIgnoreCase);
            }

            return false;
        }
    }
}
