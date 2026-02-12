using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formulario
{
    public partial class Form1 : Form
    {
        private string[] archivosImagenes;
        private Timer timer = new Timer();
        private Timer intervaloImagen = new Timer();
        private int intervalo = 1000;
        private int indice = 0;

        public Form1()
        {
            InitializeComponent();
            this.timer.Interval = 1000;
            this.intervaloImagen.Interval = this.intervalo;
            this.intervaloImagen.Tick += Tick_IntervaloImagen;
            this.timer.Tick += Timer_Tick;
            for (int i = 1; i <= 20; i++)
            {
                this.cbSeconds.Items.Add(i);
            }
            this.cbSeconds.SelectedIndex = 4;
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            miniReproductor1.seconds++;
        }

        private void Tick_IntervaloImagen(object sender, EventArgs e)
        {
            if (archivosImagenes != null && archivosImagenes.Length > 0)
            {
                indice++;
                if (indice >= archivosImagenes.Length)
                {
                    indice = 0;
                }
                MostrarImagen();
            }
        }

        private void miniReproductor1_PlayClick(object sender, EventArgs e)
        {
            if (miniReproductor1.IsPlaying)
            {
                if (cbSeconds.SelectedItem != null)
                {
                    int segundos = (int)cbSeconds.SelectedItem;
                    intervaloImagen.Interval = segundos * 1000;
                }

                timer.Start();
                intervaloImagen.Start();
            }
            else
            {
                timer.Stop();
                intervaloImagen.Stop();
            }
        }

        private void miniReproductor1_DesbordaTiempo(object sender, EventArgs e)
        {
            miniReproductor1.minutes++;
        }

        private void btnFolder_Click(object sender, EventArgs e)
        {
            using (FolderBrowserDialog fbd = new FolderBrowserDialog())
            {
                if (fbd.ShowDialog() == DialogResult.OK)
                {
                    archivosImagenes = Directory.GetFiles(fbd.SelectedPath, "*.*").Where(ruta => ruta.ToLower().EndsWith(".jpg") || ruta.ToLower().EndsWith(".png")).ToArray();
                    if (archivosImagenes.Length > 0)
                    {
                        indice = 0;
                        intervalo = (int)cbSeconds.SelectedItem * 1000;

                        MostrarImagen();
                    }
                    else
                    {
                        MessageBox.Show("No se encontraron imágenes");
                    }
                }
            }
        }

        private void MostrarImagen()
        {
            if (archivosImagenes != null && archivosImagenes.Length > 0)
            {
                if (pictureBox1.Image != null)
                {
                    pictureBox1.Image.Dispose();
                }

                pictureBox1.Image = Image.FromFile(archivosImagenes[indice]);
            }
        }
    }
}
