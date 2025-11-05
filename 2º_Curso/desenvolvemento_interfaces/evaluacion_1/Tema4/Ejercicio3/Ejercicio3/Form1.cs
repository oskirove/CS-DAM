using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio3
{
    public partial class Form1 : Form
    {
        private Timer temporizador;
        private int segundosTranscurridos = 0;

        public Form1()
        {
            InitializeComponent();
            checkBox1.CheckedChanged += (s, e) => cambiarColorTexto();
            temporizador = new Timer();
            temporizador.Interval = 1000;
            temporizador.Tick += Temporizador_Tick;
            temporizador.Start();
        }

        private void Temporizador_Tick(object sender, EventArgs e)
        {
            segundosTranscurridos++;

            int minutos = segundosTranscurridos / 60;
            int segundos = segundosTranscurridos % 60;

            this.Text = $"Visor de imágenes {minutos:D2}:{segundos:D2}";
        }


        private void cambiarColorTexto()
        {
            if (checkBox1.Checked)
            {
                checkBox1.ForeColor = Color.Red;
            }
            else
            {
                checkBox1.ForeColor = Color.Black;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog d = new OpenFileDialog();

            d.Filter = "Image files (*.png;*.jpg)|*.png;*.jpg|All files (*.*)|*.*";
            d.FilterIndex = 2;

            string filePath = string.Empty;

            if (d.ShowDialog() == DialogResult.OK)
            {
                filePath = d.FileName;
                Form2 f = new Form2(filePath);

                if (checkBox1.Checked) f.ShowDialog();

                if (!checkBox1.Checked) f.Show();

            }
            else
            {
                MessageBox.Show("Acción cancelada", this.Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
    }
}
