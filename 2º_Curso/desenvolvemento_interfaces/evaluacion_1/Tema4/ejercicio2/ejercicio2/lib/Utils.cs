using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio2.lib
{
    internal class Utils
    {
        public int CheckText(string text)
        {
            if (!int.TryParse(text, out int valor)) throw new ArgumentException("Solo se permite introducir números en los campos.");

            if (valor < 0 || valor > 255) throw new ArgumentException("Los valores deben estar entre 0 y 255.");

            return valor;
        }
    }
}
