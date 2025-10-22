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
                            string nombreAstro = Functions.solicitarCadena("Introduce el nombre del astro: ");

                            Astro buscado = new Planeta(nombreAstro, 0, false, 0);
                            int index = coleccion.IndexOf(buscado);

                            if (index == -1)
                            {
                                Console.WriteLine("Planeta no encontrado");
                            }
                            else
                            {
                                Astro astro = coleccion[index];

                                if (astro is Planeta p)
                                {
                                    string letra = Functions.solicitarCadena("Introduce - i - para incremantar o - d - para decrementar: ");

                                    switch (letra)
                                    {
                                        case "i":
                                            p++;
                                            break;
                                        case "d":
                                            p--;
                                            break;
                                        default:
                                            Console.BackgroundColor = ConsoleColor.Red;
                                            Console.ForegroundColor = ConsoleColor.White;
                                            Console.WriteLine();
                                            Console.WriteLine("Esta opción no es válida");
                                            Console.WriteLine();
                                            Console.ResetColor();
                                            break;
                                    }

                                    Console.WriteLine($"Estado actual del planeta: {p}");

                                }
                                else
                                {
                                    Console.BackgroundColor = ConsoleColor.Red;
                                    Console.ForegroundColor = ConsoleColor.White;
                                    Console.WriteLine();
                                    Console.WriteLine("El astro encontrado no es un planeta");
                                    Console.WriteLine();
                                    Console.ResetColor();
                                }
                            }

                            break;
                        case 5:
                            for (int i = coleccion.Count - 1; i > 0; i--)
                            {
                                Astro astro = coleccion[i];

                                if (astro is Planeta p)
                                {
                                    if (!p.esHabitable())
                                    {
                                        coleccion.RemoveAt(i);
                                    }
                                }
                                else if (astro is Cometa c)
                                {
                                    if (!c.esHabitable())
                                    {
                                        coleccion.RemoveAt(i);
                                    }
                                }
                            }
                            break;
                        case 6:
                            Console.WriteLine("Saliendo del programa.");
                            break;
                        default:
                            Console.BackgroundColor = ConsoleColor.Red;
                            Console.ForegroundColor = ConsoleColor.White;
                            Console.WriteLine();
                            Console.WriteLine("Esta opción no es válida");
                            Console.WriteLine();
                            Console.ResetColor();
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
