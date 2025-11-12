using ejercicio_2.lib;

namespace ejercicio_2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int opcion;

            do
            {
                Console.WriteLine("Carrera de caballos");
                Console.WriteLine();
                Console.WriteLine("1.- Iniciar carrera");
                Console.WriteLine("2.- Salir del programa");
                Console.WriteLine();
                opcion = Utils.solicitarEntero("Introduce una opción: ");
                Console.WriteLine();

                switch (opcion)
                {
                    case 1:
                        Utils utils = new Utils();

                        int apuesta = Utils.solicitarEntero("Apuesta por un caballo [1 - 5]: ");
                        Console.Clear();
                        
                        int caballoGanador = utils.inicializarCaballos();

                        Thread.Sleep(1000);

                        if (apuesta == caballoGanador)
                        {
                            Console.WriteLine($"¡Felicidades! El caballo {caballoGanador} ha ganado. Has acertado tu apuesta.");
                        }
                        else
                        {
                            Console.WriteLine($"Lo siento, el caballo ganador fue el {caballoGanador}.");
                        }

                        break;
                    case 2:
                        Console.WriteLine("Saliendo del programa...");
                        break;
                    default:
                        Console.WriteLine("Opción no válida. Por favor, elige 1 o 2.");
                        break;
                }
            }
            while (opcion != 2);
        }
    }
}
