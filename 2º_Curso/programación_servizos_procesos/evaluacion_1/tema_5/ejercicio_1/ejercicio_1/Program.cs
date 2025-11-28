namespace ejercicio_1
{
    internal class Program
    {
        static bool running = true;
        static readonly object t = new object();
        static void Main(string[] args)
        {
            int contador = 0;

            Thread hilo1 = new Thread(() =>
            {
                while (running)
                {
                    lock (t)
                    {
                        if (running)
                        {


                            contador++;

                            Console.ForegroundColor = ConsoleColor.Cyan;
                            Console.WriteLine("Hilo 1: " + contador);

                            if (contador >= 500)
                            {
                                running = false;
                                Console.WriteLine();
                                Console.WriteLine("Hilo 1 ha terminado la ejecución.");
                            }

                            Console.ResetColor();
                        }
                    }
                }
            });

            Thread hilo2 = new Thread(() =>
            {
                while (true)
                {
                    lock (t)
                    {
                        if (!running)
                        {
                            break;
                        }
                        contador--;

                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.WriteLine("Hilo 2: " + contador);

                        if (contador <= -500)
                        {
                            running = false;
                            Console.WriteLine();
                            Console.WriteLine("Hilo 2 ha terminado la ejecución.");
                        }

                        Console.ResetColor();
                    }
                }
            });

            hilo1.Start();
            hilo2.Start();
            //Espera e indica el ganador
        }
    }
}
