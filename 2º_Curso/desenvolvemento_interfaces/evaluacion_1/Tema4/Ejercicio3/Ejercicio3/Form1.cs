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
        public Form1()
        {
            InitializeComponent();
            cambiarColorTexto();

        }

        private void cambiarColorTexto()
        {
            if (checkBox1.Checked)
            {
                string[] texto = checkBox1.Text.Split();
                string palabra = texto.Length > 2 ? texto[2] : "";
                checkBox1.Text = $"{texto[0]} {texto[1]} {palabra}";
                checkBox1.ForeColor = Color.Green;
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
