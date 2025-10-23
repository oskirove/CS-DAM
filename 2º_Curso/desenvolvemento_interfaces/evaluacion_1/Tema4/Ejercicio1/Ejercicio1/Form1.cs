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
        public Form1()
        {
            InitializeComponent();

            this.MouseLeave += Form_MouseLeave;
            this.MouseMove += Form_MouseMove;
            button1.MouseMove += Form_MouseMove;
            button2.MouseMove += Form_MouseMove;
        }

        private void Form_MouseMove(object sender, MouseEventArgs e)
        {
            Point p = this.PointToClient(Cursor.Position);
            this.Text = $"Mouse Tester - X:{p.X}, Y:{p.Y}";
        }

        private void Form_MouseLeave(object sender, EventArgs e)
        {
            this.Text = "Mouse Tester - X:0, Y:0";
        }
    }
}
