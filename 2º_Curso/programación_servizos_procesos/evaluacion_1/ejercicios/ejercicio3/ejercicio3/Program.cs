using ejercicio3.lib;
using System.Security.Cryptography.X509Certificates;

namespace ejercicio3
{
    internal class Program
    {

        public delegate double Operacion(double valor);

        static void Main(string[] args)
        {
            Utils utils = new Utils();
            int? opcion = null;
            double valor = utils.solicitarDouble("Introduce un número valido: ");

            do
            {
                Console.WriteLine("Menú de opciones");
                Console.WriteLine("1._ Obtener el cuadrado.");
                Console.WriteLine("2._ Obtener el cubo.");

                opcion = utils.solicitarEntero("Introuce un numero entero válido: ");

                Operacion op = new Operacion(utils.calcularCubo);


                switch (opcion)
                {
                    case 1:
                        op = new Operacion(utils.calcularCubo);
                        Console.WriteLine("Resultado: " + op(valor));

                        break;
                    case 2:
                        op = new Operacion(utils.calcularCuadrado);
                        Console.WriteLine("Resultado: " + op(valor));

                        break;
                    case 0:
                        Console.WriteLine("Saliendo del programa");

                        break;
                    default:

                        Console.WriteLine("Esta opción no es valida");
                        break;
                }
            }
            while (opcion!=0);
        }
    }
}
