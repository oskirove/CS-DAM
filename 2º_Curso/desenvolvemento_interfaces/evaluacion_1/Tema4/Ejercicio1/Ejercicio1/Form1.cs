using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio1
{
    public partial class Form1 : Form//Revisar colore botones,. Coor en todos los botones. Icono. restaurar titulo al salir raton.
    {
        private string title = "Mouse Tester";
        public Form1()
        {
            InitializeComponent();

            this.KeyPreview = true;

            this.MouseLeave += Form_MouseLeave;
            this.MouseMove += Form_MouseMove;
            button1.MouseMove += Form_MouseMove;
            button2.MouseMove += Form_MouseMove;
            pictureBox1.MouseDown += pictureBox1_Pressed;
            pictureBox1.MouseUp += pictureBox1_NotPressed;
            this.KeyDown += Form_KeyPressed;
            this.FormClosing += closeForm;
            crearBotonesDinamicos();
        }

        private void Form_MouseMove(object sender, MouseEventArgs e)
        {
            Point p = this.PointToClient(Cursor.Position);//Sin esto. Detecta si es formulario o no
            this.Text = $"{title} - X:{p.X}, Y:{p.Y}";
        }

        private void Form_MouseLeave(object sender, EventArgs e)
        {
            this.Text = $"{title} - X:0, Y:0";
        }

        private void pictureBox1_Pressed(object sender, EventArgs e)
        {
            button1.BackColor = Color.Aqua;
            button2.BackColor = Color.Red;
        }
        private void pictureBox1_NotPressed(object sender, EventArgs e)
        {
            button1.BackColor = SystemColors.Control;
            button2.BackColor = SystemColors.Control;
        }

        private void Form_KeyPressed(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Escape)
            {
                this.Text = "Mouse Tester";
            }
            else
            {
                title = e.KeyCode.ToString();
                this.Text = title;
            }
        }

        private void crearBotonesDinamicos()
        {
            int filas = 4;
            int columnas = 5;
            int ancho = 60;
            int alto = 40;
            int margen = 30;
            int offsetX = 70;
            int offsetY = 180;

            int contador = 1;

            for (int fila = 0; fila < filas; fila++)
            {
                for (int columna = 0; columna < columnas; columna++)
                {
                    Button btn = new Button();
                    btn.Text = contador.ToString();
                    btn.Width = ancho;
                    btn.Height = alto;
                    btn.Left = offsetX + columna * (ancho + margen);
                    btn.Top = offsetY + fila * (alto + margen);

                    btn.MouseDown += (s, e) => { btn.ForeColor = Color.Red; };
                    btn.MouseUp += (s, e) => { btn.ForeColor = Color.Black; };

                    this.Controls.Add(btn);
                    contador++;
                }
            }
        }

        private void closeForm(object sender, FormClosingEventArgs e)
        {
            DialogResult resultado = MessageBox.Show(
                "¿Estás seguro de que quieres salir?",
                "Confirmar salida",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question
            );

            if (resultado == DialogResult.No)
            {
                e.Cancel = true;
            }

        }
    }
}
