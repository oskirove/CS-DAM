using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio3.lib
{
    internal class Utils
    {
        public double solicitarDouble(string mensaje)
        {

            while (true)
            {
                Console.WriteLine(mensaje);
                string? input = Console.ReadLine();

                bool result = double.TryParse(input, out double valor);

                if (string.IsNullOrEmpty(input))
                {
                    Console.WriteLine("Error: El campo no puede estar vacío.");
                    continue;
                }

                if (!result)
                {
                    Console.WriteLine("Error: Debes introducir un número válido");
                    continue;
                }

                return valor;
            }
        }

        public int solicitarEntero(string mensaje)
        {

            while (true)
            {
                Console.WriteLine(mensaje);
                string? input = Console.ReadLine();

                bool result = int.TryParse(input, out int valor);

                if (string.IsNullOrEmpty(input))
                {
                    Console.WriteLine("Error: El campo no puede estar vacío.");
                    continue;
                }

                if (!result)
                {
                    Console.WriteLine("Error: Debes introducir un número válido");
                    continue;
                }

                return valor;
            }
        }

        public double calcularCuadrado(double valor)
        {
            return Math.Pow(valor, 2);
        }

        public double calcularCubo(double valor)
        {
            return Math.Pow(valor, 3);
        }
    }
}
