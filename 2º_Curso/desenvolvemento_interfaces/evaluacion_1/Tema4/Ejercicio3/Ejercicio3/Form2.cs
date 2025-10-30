using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio3
{
    public partial class Form2 : Form
    {
        public Form2(string imagePath)
        {
            InitializeComponent();
            visualizarImagen(imagePath);

            this.Text = imagePath;
        }

        private void ajustarPerfectamenteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
        }

        private void ajustarSinDeformarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
        }
        private void visualizarImagen(string imagePath)
        {
            pictureBox1.ImageLocation = imagePath;
        }
    }
}
