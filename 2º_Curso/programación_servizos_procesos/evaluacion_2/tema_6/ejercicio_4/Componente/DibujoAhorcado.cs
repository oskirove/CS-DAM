using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Componente
{
    public partial class DibujoAhorcado : UserControl
    {

        private int errores = 0;
        public int Errores
        {
            get { return errores; }
            set
            {
                if (value < 0 || value > 7)
                {
                    this.OnAhorcado(EventArgs.Empty);
                }

                if (value == 7)
                {
                    this.OnAhorcado(EventArgs.Empty);
                }

                errores = value;

                this.OnCambiaError(EventArgs.Empty);
                this.Refresh();
            }
        }

        [Category("Errores")]
        [Description("Se lanza al actualizar el registro de errores")]
        public event EventHandler CambiaError;

        [Category("Dibujo")]
        [Description("Se lanza al completar el dibujo")]
        public event EventHandler Ahorcado;

        public DibujoAhorcado()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            int h = this.Height;
            int w = this.Width;

            base.OnPaint(e);
            Graphics g = e.Graphics;
            Pen pen = new Pen(Color.Black, 3);

            // Horca
            if (errores >= 1)
            {
                // Base
                g.DrawLine(pen, w * 0.1f, h * 0.9f, w * 0.9f, h * 0.9f);
                // Poste
                g.DrawLine(pen, w * 0.3f, h * 0.2f, w * 0.3f, h * 0.9f);
                // Linea horizontal
                g.DrawLine(pen, w * 0.3f, h * 0.2f, w * 0.5f, h * 0.2f);
                // Soga
                g.DrawLine(pen, w * 0.5f, h * 0.2f, w * 0.5f, h * 0.35f);
            }

            // Cabeza
            if (errores >= 2)
            {
                g.DrawEllipse(pen, w * 0.45f, h * 0.35f, w * 0.1f, h * 0.15f);
            }

            // Cuerpo
            if (errores >= 3)
            {
                g.DrawLine(pen, w * 0.5f, h * 0.5f, w * 0.5f, h * 0.7f);
            }

            // brazo izquierdo
            if (errores >= 4)
            {
                g.DrawLine(pen, w * 0.5f, h * 0.55f, w * 0.4f, h * 0.5f);
            }

            // brazo derecho
            if (errores >= 5)
            {
                g.DrawLine(pen, w * 0.5f, h * 0.55f, w * 0.6f, h * 0.5f);
            }

            // pierna izquierdo
            if (errores >= 6)
            {
                g.DrawLine(pen, w * 0.5f, h * 0.7f, w * 0.4f, h * 0.8f);
            }

            // pierna derecho
            if (errores >= 7)
            {
                g.DrawLine(pen, w * 0.5f, h * 0.7f, w * 0.6f, h * 0.8f);
            }
        }

        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            this.Refresh();
        }

        protected virtual void OnCambiaError(EventArgs e)
        {
            CambiaError?.Invoke(this, e);
        }

        protected virtual void OnAhorcado(EventArgs e)
        {
            Ahorcado?.Invoke(this, e);
        }
    }
}
