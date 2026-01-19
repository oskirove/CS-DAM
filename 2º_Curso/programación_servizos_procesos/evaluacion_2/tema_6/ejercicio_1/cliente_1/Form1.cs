using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_1
{
    public partial class Form1 : Form
    {
        private string[] cadenas = { "Time", "Date", "All", "Close" };
        private int port = 4321;
        private IPAddress ip = IPAddress.Parse("127.0.0.1");

        public Form1()
        {
            InitializeComponent();
        }

        private async Task<String> SendRecepAsync(string tag)
        {
            try
            {
                using (Socket conexion = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
                {
                    string response = null;
                    IPEndPoint ep = new IPEndPoint(ip, port);

                    await conexion.ConnectAsync(ep);

                    Encoding codificacion = Console.OutputEncoding;
                    using (NetworkStream ns = new NetworkStream(conexion))
                    using (StreamReader sr = new StreamReader(ns, codificacion))
                    using (StreamWriter sw = new StreamWriter(ns, codificacion))
                    {

                        switch (tag)
                        {
                            case "time":
                                await sw.WriteLineAsync("");
                                break;

                            case "date":

                                break;

                            case "all":

                                break;

                            case "close":

                                break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            for (int i = 0; i < 4; i++)
            {
                int x = 120;
                int y = 180;
                int anchoBoton = 60;
                int espacioBotones = 12;

                int nuevaX = x + (i - 1) * (anchoBoton + espacioBotones);

                Button boton = new Button();

                boton.Left = (this.ClientSize.Width - tbContraseña.Width) / 2;
                boton.Top = (this.ClientSize.Height - tbContraseña.Height) / 2;

                boton.Location = new Point(nuevaX, y);
                boton.Text = cadenas[i];
                boton.Tag = cadenas[i];

                this.Controls.Add(boton);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2();

            f.ShowDialog();

            if (f.DialogResult == DialogResult.OK)
            {
                port = f.port;
                ip = f.ip;
            }
        }
    }
}
