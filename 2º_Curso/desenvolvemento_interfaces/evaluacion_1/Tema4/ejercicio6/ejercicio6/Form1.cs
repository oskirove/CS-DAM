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
    public partial class Form1 : Form
    {

        private FileInfo[] rutas;
        public Form1()
        {
            InitializeComponent();
            this.FormClosing += Form1_FormClosing;
        }
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult result = MessageBox.Show("¿Estás seguro de que quieres salir?", "Salir", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);

            if (result == DialogResult.No)
            {
                e.Cancel = true;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (FolderBrowserDialog dialog = new FolderBrowserDialog())
            {
                dialog.Description = "Selecciona una carpeta";
                dialog.ShowNewFolderButton = true;

                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    string selectedPath = dialog.SelectedPath;

                    DirectoryInfo dir = new DirectoryInfo(selectedPath);

                    FileInfo[] files = dir.GetFiles();

                    this.rutas = files;

                    int margin = 15;
                    int columns = 4;
                    int width = 100;
                    int height = 80;

                    for (int i = 0; i < files.Length; i++)
                    {
                        PictureBox preview = new PictureBox();
                        preview.SizeMode = PictureBoxSizeMode.StretchImage;
                        preview.Width = width;
                        preview.Height = height;

                        int row = i / columns;
                        int column = i % columns;

                        preview.Left = column * (width + margin);
                        preview.Top = row * (height + margin);

                        preview.Tag = files[i].FullName;

                        preview.Click += PictureBox_Click;

                        preview.Image = Image.FromFile(files[i].FullName);
                        
                        panel1.Controls.Add(preview);
                    }
                }
            }   
        }

        public void PictureBox_Click(object sender, EventArgs e)
        {
            PictureBox clicked = sender as PictureBox;
            string ruta = clicked.Tag as string;

            Form2 f = new Form2(ruta, rutas);
            f.ShowDialog();
        }
    }
}
