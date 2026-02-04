using System;
using System.Collections.Generic;
using System.Text;

namespace servidor
{
    internal class Record
    {
        public string User { get; set; }
        public int Seconds { get; set; }


        public Record(string user, int seconds)
        {
            User = user;
            Seconds = seconds;
        }
    }
}
