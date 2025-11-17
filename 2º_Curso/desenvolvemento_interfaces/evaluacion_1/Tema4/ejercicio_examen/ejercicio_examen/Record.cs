using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio_examen
{
    internal class Record
    {
        private string nombre;
        private int edad;
        private int puntuacion;

        public Record(string nombre, int edad, int puntuacion)
        {
            this.nombre = nombre;
            this.edad = edad;
            this.puntuacion = puntuacion;
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int Edad
        {
            get { return edad; }
            set
            {
                if (value >= 0)
                    edad = value;
                else
                    throw new ArgumentException("La edad no puede ser negativa.");
            }
        }

        public int Puntuacion
        {
            get { return puntuacion; }
            set
            {
                if (value >= 0 && value <= 100)
                    puntuacion = value;
                else
                    throw new ArgumentException("La puntuación debe estar entre 0 y 100.");
            }
        }


        public override string ToString()
        {
            return $"Nombre: {nombre}, Edad: {edad}, Puntuación: {puntuacion}";
        }
    }
}
