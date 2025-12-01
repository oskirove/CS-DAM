using ejercicio4.lib;
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

namespace ejercicio4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //C:\Users\oscar\source\repos\CS-DAM\2º_Curso\programación_servizos_procesos\evaluacion_1\tema_5\ejercicio4\ejercicio4

        private async void button1_Click(object sender, EventArgs e)
        {
            string ruta = textBox1.Text;
            string palabraBuscada = textBox2.Text;

            Utils utils = new Utils();

            // Inicializacion de colecciones
            DirectoryInfo dirs = new DirectoryInfo(ruta);

            // Validaciones
            if (string.IsNullOrEmpty(ruta))
            {
                MessageBox.Show("Debes introducir una ruta válida", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            if (string.IsNullOrEmpty(palabraBuscada))
            {
                MessageBox.Show("Debes introducir una palabra", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            if (!dirs.Exists)
            {
                MessageBox.Show($"El directorio al que intentas acceder no existe: '{e}'", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            string cadenaDevuelta = utils.BuscaPalabra(dirs, palabraBuscada);

            listBox1.Items.Add(cadenaDevuelta);
        }
    }
}
