using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            for (int i = 0; i < 4; i++)
            {
                int x = 120;
                int y = 100;
                int anchoBoton = 60;
                int espacioBotones = 12;

                int nuevaX = x + (i - 1) * (anchoBoton + espacioBotones);
                
                Button boton = new Button();
                
                boton.Tag = i;
                boton.Left = (this.ClientSize.Width - textBox.Width) / 2;
                boton.Top = (this.ClientSize.Height - textBox.Height) / 2;

                boton.Location = new Point(nuevaX, y);

                this.Controls.Add(boton);
            }
        }
    }
}
