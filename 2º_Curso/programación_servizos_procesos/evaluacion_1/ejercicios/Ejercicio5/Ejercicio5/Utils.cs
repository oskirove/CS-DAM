using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio5
{
    internal class Utils
    {
        public delegate void MyDelegate();
        public bool MenuGenerator(string[] opciones, MyDelegate[] delegados)
        {

            if (opciones == null || delegados == null)
                return false;
            if (opciones.Length != delegados.Length)
                return false;
            if (opciones.Length == 0)
                return false;

            int input = -1;

            do
            {
                int cont = 0;

                foreach (string opcion in opciones)
                {
                    cont++;
                    Console.WriteLine($"{cont}.- {opcion}");
                }
                Console.WriteLine($"{opciones.Length + 1}.- Exit");


                input = SolicitarEntero("Introduce una opcion: ");

                if (input >= 1 && input <= opciones.Length)
                {
                    delegados[input - 1]();
                }
                else if (input == opciones.Length + 1)
                {
                    Console.WriteLine("Saliendo...");
                }
                else
                {
                    Console.WriteLine("Opción no válida.");
                }
            }
            while (input != opciones.Length + 1);

            return true;
        }

        private int SolicitarEntero(string mensaje)
        {
            while (true)
            {
                Console.WriteLine(mensaje);
                string input = Console.ReadLine();

                if (string.IsNullOrEmpty(input))
                {
                    Console.WriteLine("El campo no puede estar vacío");
                    continue;
                }

                bool result = int.TryParse(input, out int valor);

                if (!result)
                {
                    Console.WriteLine("Debes introducir un número válido.");
                    continue;
                }

                return valor;
            }
        }
    }
}
