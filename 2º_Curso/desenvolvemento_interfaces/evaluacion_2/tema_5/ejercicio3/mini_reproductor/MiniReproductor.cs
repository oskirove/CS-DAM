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
        public bool IsPlaying { get; set; } = false;
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
                    Seconds = value % 60;
                    if (Seconds == 0 && value != 0)
                    {
                        this.OnDesbordaTiempo(EventArgs.Empty);
                    }
                }
                else
                {
                    Seconds = value;
                }

                ActualizarEtiqueta();
            }
        }

        private int Minutes;
        public int minutes
        {
            get { return Minutes; }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentException("Los minutos no pueden ser menores a 0");
                }

                Minutes = (value > 59) ? 0 : value;
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
                IsPlaying = true;
            }
            else
            {
                btn.Text = "▶";
                IsPlaying = false;
            }

            this.OnPlayClicK(EventArgs.Empty);
        }

        [Category("Botón pulsado")]
        [Description("Se lanza cuando el botón es pulsado")]
        public event EventHandler PlayClick;
        protected virtual void OnPlayClicK(EventArgs e)
        {
            PlayClick?.Invoke(this, e);
        }

        [Category("Tiempo excedido")]
        [Description("Se lanza cuando el tiempo se excede")]
        public event EventHandler DesbordaTiempo;
        protected virtual void OnDesbordaTiempo(EventArgs e)
        {
            DesbordaTiempo?.Invoke(this, e);
        }
    }
}
