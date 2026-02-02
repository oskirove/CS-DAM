using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace servidor
{
    internal class GameServer
    {
        private Socket MainSocket;
        int Port { get; set; } = 4321;
        private bool ServerRunning { get; set; } = true;

        public void InitServer()
        {
            using (MainSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                bool trigger = false;
                IPEndPoint ie = null;

                while (!trigger && Port <= 65535)
                {
                    try
                    {

                    }
                    catch ()
                    {

                    }
                }
            }
        }

        private void ClientDispatcher(Socket sClient)
        {

        }
    }
}
