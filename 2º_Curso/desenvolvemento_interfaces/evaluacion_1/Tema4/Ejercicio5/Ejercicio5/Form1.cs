using Ejercicio5.lib;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            resetToolStripMenuItem.Click += (s, e) => Reset_Function();
            botonReset.Click += (s, e) => Reset_Function();
            this.Load += loadButtons;
        }

        public void loadButtons(object sender, EventArgs e)
        {

            string[] teclas = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };

            int xStart = 10;
            int yStart = 50;
            int ancho = 60;
            int alto = 50;
            int margen = 10;

            for (int i = 0; i < teclas.Length; i++)
            {
                Button boton = new Button
                {
                    Text = teclas[i],
                    Size = new Size(alto, ancho),
                    Location = new Point
                    (
                        xStart + (i % 3) * (ancho + margen),
                        yStart + (i / 3) * (alto + margen)
                    )
                };

                boton.MouseEnter += (s, ev) => {((Button)s).BackColor = Color.WhiteSmoke; };
                boton.MouseLeave += (s, ev) =>
                {
                    Button b = ((Button)s);
                    if (!(bool)(b.Tag ?? false))
                    {
                        b.BackColor = SystemColors.Window;
                    }
                    else
                    {
                        b.BackColor = SystemColors.Control;
                    }
                };

                boton.Click += (s, ev) => { textScreen.Text += ((Button)s).Text; };

                boton.Click += (s, ev) =>
                {
                    Button b = ((Button)s);
                    b.BackColor = SystemColors.Control;
                    b.Tag = true;
                };

                this.Controls.Add(boton);
            }
        }

        private void grabarNúmeroToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textScreen.Text)) return;

            Form2 f = new Form2(textScreen.Text);
            f.ShowDialog();
        }

        private void Reset_Function()
        {
            textScreen.Text = null;
            foreach (Control c in this.Controls)
            {
                if (c is Button)
                {
                    c.BackColor = SystemColors.Window;
                    c.Tag = false;
                }
            }
        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Hola soy Óscar, el desarrollador de esta app.", "Teléfono v.0.0.1", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void mostarAgendaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Utils utils = new Utils();

            List<string> contactos = utils.getContactsFromFile();

            Form3 f = new Form3(contactos);
            f.Show();

        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
