using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examen_noviembre
{
    public class Recetas
    {
        public string Nombre { private set; get; }
        public string Descripcion { private set; get; }
        public int Tiempo { private set; get; }

        public Recetas(string nombre, string descripcion, int tiempo)
        {
            Nombre = nombre;
            Descripcion = descripcion;
            Tiempo = tiempo;
        }

        public override string ToString()
        {
            return Nombre;
        }

    }
}
