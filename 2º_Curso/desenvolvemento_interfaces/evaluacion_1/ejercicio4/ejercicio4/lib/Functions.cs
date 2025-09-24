using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio4.lib
{
    internal class Functions
    {
        public int solicitarEntero(string mensaje)
        {
            Console.Write(mensaje);
            string entrada = Console.ReadLine();

            int numero;

            if (int.TryParse(entrada, out numero))
            {
                return numero;
            }
            else
            {
                throw new FormatException("Debes introducir un número válido.");
            }
        }

        /*
         Un año es bisiesto si cumple estas condiciones:
         - Es divisible por 4.
         - Pero si también es divisible por 100, entonces no es bisiesto.
         - A menos que también sea divisible por 400, en cuyo caso sí lo es.

         Ejemplos:
         - 2024: divisible por 4, no por 100 → bisiesto
         - 1900: divisible por 4 y por 100, pero no por 400 → no bisiesto
         - 2000: divisible por 4, por 100 y por 400 → bisiesto
         */
        public bool checkBisiesto(int year)
        {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        public int? sumaRango(int n1, int n2)
        {
            if (n1 > n2) return null;

            int acumulador = 0;

            int init = n1 + 1;

            for (int i = init; i < n2; i++)
            {
                acumulador += i;
            }

            return acumulador;
        }
    }
}
