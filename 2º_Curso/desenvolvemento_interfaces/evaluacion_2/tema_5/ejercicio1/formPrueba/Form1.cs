using ejercicio1;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace formPrueba
{
    public partial class Form1 : Form
    {
        private int cont = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            cont++;

            if (cont > 1)
            {
                cont = 0;
            }

            switch (cont)
            {
                case 0:
                    labelTextbox1.Posicion = LabelTextbox.EPosicion.IZQUIERDA;
                    break;
                case 1:
                    labelTextbox1.Posicion = LabelTextbox.EPosicion.DERECHA;
                    break;
            }
        }
    }
}
