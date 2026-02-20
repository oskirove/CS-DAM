using System;
using System.Collections.Generic;
using System.Text;

namespace ejercicio_5
{
    internal class FlyRunner
    {
        public StringWriter Sw { get; set; }
        public int KilledFlies { get; set; }
        public int Bites { get; set; } = 0;

        public FlyRunner(StringWriter sw)
        {
            Sw = sw;
            KilledFlies = 0;
            Bites = 0;
        }
    }
}
