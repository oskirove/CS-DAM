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

namespace ejercicio6
{
    public partial class Form2 : Form // Preguntar a Curro por el aumento de uso de memoria al volver a la primera imagen
    {
        private FileInfo[] rutas;
        private int index;

        public Form2(string rutaActual, FileInfo[] rutas)
        {
            InitializeComponent();
            this.rutas = rutas;
            pictureBox1.Image = Image.FromFile(rutaActual);
            setIndex(rutaActual);
            ActualizarInfo();
        }

        private void ActualizarInfo()
        {
            FileInfo archivo = rutas[index];
            this.Text = archivo.Name;
            lblDir.Text = archivo.DirectoryName;
            lblName.Text = archivo.Name;
            lblSize.Text = (archivo.Length / 1024).ToString() + " KB";
            lblWidth.Text = pictureBox1.Image.Width.ToString() + " px";
            lblHeight.Text = pictureBox1.Image.Height.ToString() + " px";
        }

        private void setIndex(string rutaActual)
        {
            for (int i = 0; i < rutas.Length; i++)
            {
                if (rutas[i].FullName == rutaActual)
                {
                    index = i;
                    break;
                }
            }
        }

        private void btnAtras_Click(object sender, EventArgs e)
        {
            if (index > 0)
            {
                index--;

                // Hago esto para liberar la imagen anterior y
                // evitar que aumente sin sentido el uso de memoria
                pictureBox1.Image?.Dispose();
                pictureBox1.Image = Image.FromFile(rutas[index].FullName);
               // GC.Collect();
                ActualizarInfo();
            }

        }

        private void btnAvanzar_Click(object sender, EventArgs e)
        {
            if (index < rutas.Length - 1)
            {
                index++;
                pictureBox1.Image?.Dispose();
                pictureBox1.Image = Image.FromFile(rutas[index].FullName);
                ActualizarInfo();
            }
        }

    }
}
