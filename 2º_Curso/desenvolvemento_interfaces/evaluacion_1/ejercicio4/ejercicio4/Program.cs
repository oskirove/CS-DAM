using ejercicio4.lib;
using System.Linq.Expressions;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace ejercicio4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            do
            {
                Console.WriteLine("MENÚ");
                Console.WriteLine("1.- Comprueba si un año es bisiesto.");
                Console.WriteLine("2.- Suma de rango de números.");
                Console.WriteLine("3.- Realizar las dos primeras opciones.");
                Console.WriteLine("4.- Salir.");
                Console.WriteLine();

                try
                {
                    Functions f = new Functions();
                    opcion = f.solicitarEntero("Introduce una opcion: ");

                    switch (opcion)
                    {
                        case 1:
                            bool trigger1 = false;
                            while (!trigger1)
                            {
                                int año = f.solicitarEntero("Introduce un año: ");
                                Console.WriteLine();

                                if (año < 0 || año > 10000)
                                {
                                    Console.WriteLine("Introduce un año entre 0 y 10000");
                                }
                                else
                                {
                                    trigger1 = true;
                                }

                                Console.WriteLine(f.checkBisiesto(año) ? "El año {0} es bisiesto." : "El año {1} no es bisiesto.", año, año);
                                Console.WriteLine();
                            }

                            if (opcion == 3)
                            {
                                goto case 2;
                            }

                            break;
                        case 2:
                            bool triggerOption1 = false;
                            bool triggerOption2 = false;

                            int n1 = 0;
                            int n2 = 0;

                            while (!triggerOption1)
                            {
                                n1 = f.solicitarEntero("introduce el primer valor: ");

                                if (n1 > 10000 || n1 < 0)
                                {
                                    Console.WriteLine("El valor debe ser positivo y menor que 10000");
                                }
                                else
                                {
                                    triggerOption1 = true;
                                }
                            }

                            while (!triggerOption2)
                            {
                                n2 = f.solicitarEntero("Introduce el segundo valor: ");

                                if (n2 > 10000 || n2 < 0)
                                {
                                    Console.WriteLine("El valor debe ser positivo y menor que 10000");
                                }
                                else
                                {
                                    triggerOption2 = true;
                                }
                            }

                            if (f.sumaRango(n1, n2) == null)
                            {
                                Console.WriteLine("Error: El primer valor no puede ser mayor que el segundo valor.");
                            }
                            else
                            {
                                Console.WriteLine("La suma del rango es: {0}", f.sumaRango(n1, n2));
                            }

                            break;
                        case 3:
                            goto case 1;
                            
                            break;
                        case 4:
                            Console.WriteLine("Saliendo.");
                            break;
                        default:
                            Console.WriteLine("Número no reconocido.");
                            break;
                    }
                }
                catch (FormatException e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            while (opcion != 4);
        }
    }
}
