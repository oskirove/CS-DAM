using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace ejercicio_2.lib
{
    internal class User
    {
        public string Username { set; get; }
        public IPAddress IP { set; get; }
        public StreamWriter Sw { set; get; }

        public User(string username, IPAddress ip, StreamWriter sw)
        {
            Username = username;
            IP = ip;
            Sw = sw;
        }
    }
}
