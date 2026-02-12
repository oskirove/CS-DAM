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

namespace cliente
{
    public partial class Form1 : Form
    {
        private int port = 4321;
        private int[] indicesAcertados = null;
        private IPAddress ip = IPAddress.Parse("127.0.0.1");
        private string palabra = null;

        public Form1()
        {
            InitializeComponent();
            button2.Enabled = false;
        }

        private async Task<string> SendRecepAsync(string comando)
        {
            try
            {
                using (Socket conexion = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
                {
                    await conexion.ConnectAsync(new IPEndPoint(ip, port));

                    Encoding encoding = Encoding.UTF8;
                    using (NetworkStream ns = new NetworkStream(conexion))
                    using (StreamWriter sw = new StreamWriter(ns, encoding) { AutoFlush = true })
                    using (StreamReader sr = new StreamReader(ns, encoding))
                    {
                        await sw.WriteLineAsync(comando);

                        string response = await sr.ReadLineAsync();
                        return response;
                    }
                }
            }
            catch (Exception e)
            {
                return $"Error: {e.Message}";
            }
        }
        private void dibujoAhorcado1_Ahorcado(object sender, EventArgs e)
        {
            MessageBox.Show("Has perdido");
        }

        private void dibujoAhorcado1_CambiaError(object sender, EventArgs e)
        {
            MessageBox.Show($"Te faltan {7 - dibujoAhorcado1.Errores} intentos.");
        }


        private async void button1_Click(object sender, EventArgs e)
        {
            palabra = await SendRecepAsync("gw");
            lblDebug.Text = palabra;

            button2.Enabled = true;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string palabraComparar = textBox1.Text.ToUpper().Trim();

            if (string.IsNullOrEmpty(palabraComparar))
            {
                MessageBox.Show("Introduce una palabra");
            }
            else if (palabraComparar == palabra)
            {
                MessageBox.Show("Has adivinado la palabra");
                GenerateLabels(null);
                palabra = null;
            }
            else
            {
                indicesAcertados = CheckIndexes(palabraComparar);

                if (indicesAcertados.Length == 0)
                {
                    dibujoAhorcado1.Errores++;
                }

                GenerateLabels(indicesAcertados);
            }
        }

        private void GenerateLabels(int[] aciertos)
        {
            if (palabra == null) return;

            for (int i = this.Controls.Count - 1; i >= 0; i--)
            {
                Control c = this.Controls[i];

                if (c is Label && c.Tag is int)
                {
                    this.Controls.RemoveAt(i);
                    c.Dispose();
                }
            }

            for (int i = 0; i < palabra.Length; i++)
            {

                Label lbl = new Label();
                lbl.Font = new Font("Arial", 14, FontStyle.Bold);
                lbl.AutoSize = true;
                lbl.Top = 230;
                lbl.Left = 200 + (i * 30);
                lbl.Tag = i;


                if (aciertos != null && aciertos.Contains(i))
                {
                    lbl.Text = palabra[i].ToString();
                }
                else
                {
                    lbl.Text = "_";
                }

                this.Controls.Add(lbl);
            }
        }

        private int[] CheckIndexes(string palabraComparar)
        {
            List<int> indices = new List<int>();

            if (palabraComparar.Length != palabra.Length)
            {
                MessageBox.Show("Como va a ser esta la palabra si no tienen ni el mismo número de caracteres, lerdo.");
            }
            else
            {
                for (int i = 0; i < palabra.Length; i++)
                {
                    if (palabra[i] == palabraComparar[i])
                    {
                        indices.Add(i);
                    }
                }

            }

            return indices.ToArray();
        }

    }
}
