using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mini_reproductor
{
    public partial class MiniReproductor : UserControl
    {
        public event EventHandler PlayClick;
        public event EventHandler DesbordaTiempo;

        private int Seconds;
        public int seconds
        {
            get { return Seconds; }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentException("Ls segundos no pueden ser menores a 0");
                }

                if (value > 59)
                {
                    seconds = value % 60;
                    if (seconds == 0 && value != 0)
                    {
                        DesbordaTiempo?.Invoke(this, EventArgs.Empty);
                    }
                }
                else
                {
                    seconds = 0;
                }

                ActualizarEtiqueta();
            }
        }

        private int Minutes;
        public int minutes
        {
            get { return Minutes; }
            set { 
                if(value < 0)
                {
                    throw new ArgumentException("Los minutos no pueden ser menores a 0");
                }

                minutes = (value > 59) ? 0 : value;
                ActualizarEtiqueta();
            }
        }
        public MiniReproductor()
        {
            InitializeComponent();
        }

        private void ActualizarEtiqueta()
        {
            label1.Text = $"{Minutes:D2}:{Seconds:D2}";
        }

        private void btn_Click(object sender, EventArgs e)
        {
            if (btn.Text == "▶")
            {
                btn.Text = "⏸";
            }
            else
            {
                btn.Text = "▶";
            }

            PlayClick?.Invoke(this, EventArgs.Empty);
        }
    }
}
