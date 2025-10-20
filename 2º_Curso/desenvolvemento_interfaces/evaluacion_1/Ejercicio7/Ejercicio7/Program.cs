using Ejercicio7.Clases;
using Ejercicio7.lib;
using System.Collections;

namespace Ejercicio7
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            List<Astro> coleccion = new List<Astro>();

            do
            {
                try
                {
                    Console.WriteLine("--- MENÚ DE GESTIÓN DE ASTROS ---");
                    Console.WriteLine("1 - Añadir un planeta.");
                    Console.WriteLine("2 - Añadir un Cometa.");
                    Console.WriteLine("3 - Mostrar datos.");
                    Console.WriteLine("4 - Incrementar / decremetar satélites.");
                    Console.WriteLine("5 - Eliminar no terraformables.");
                    Console.WriteLine("6 - Salir del menú.");

                    opcion = Functions.solicitarEntero("Introduce una opción: ");

                    switch (opcion)
                    {
                        case 1:
                            string nombrePlaneta = Functions.solicitarCadena("Introduce el nombre del planeta: ");
                            double radioPlaneta = Functions.solicitarReal("Introduce el radio del planeta: ");
                            int lunasPlaneta = Functions.solicitarEntero("Cuantas lunas tiene el planeta " + nombrePlaneta + ": ");
                            bool esGaseoso = Functions.preguntarGaseoso("¿Es gaseoso? Y / N: ");
                            Planeta planeta = new Planeta(nombrePlaneta, radioPlaneta, esGaseoso, lunasPlaneta);

                            coleccion.Add(planeta);

                            break;
                        case 2:
                            string nombreCometa = Functions.solicitarCadena("Introduce el nombre del cometa: ");
                            double radioCometa = Functions.solicitarReal("Introduce el radio del cometa: ");
                            Cometa cometa = new Cometa(nombreCometa, radioCometa);

                            coleccion.Add(cometa);
                            break;
                        case 3:
                            foreach (var item in coleccion)
                            {
                                Console.WriteLine(item);
                            }
                            break;
                        case 4:
                            Console.WriteLine("Hola mundo");
                            break;
                        case 5:
                            Console.WriteLine("Hola mundo");
                            break;
                        case 6:
                            Console.WriteLine("Saliendo del programa.");
                            break;
                        default:
                            Console.WriteLine("Introduce una opción válida");
                            break;
                    }
                }
                catch (Exception e)
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine();
                    Console.WriteLine("ERROR: " + e.Message);
                    Console.WriteLine();
                    Console.ResetColor();
                }
            }
            while (opcion != 6);
        }
    }
}
