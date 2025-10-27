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
    public partial class Form1 : Form
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
        }

        private void Form_MouseMove(object sender, MouseEventArgs e)
        {
            Point p = this.PointToClient(Cursor.Position);
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
            title = e.KeyCode.ToString();
            this.Text = title;
        }
    }
}
