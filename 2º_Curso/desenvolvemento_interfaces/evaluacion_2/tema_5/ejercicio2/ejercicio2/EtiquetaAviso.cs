using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace ejercicio2
{
    public class EtiquetaAviso : Control
    {
        public enum EMarca
        {
            Nada,
            Cruz,
            Circulo,
            Imagen
        }

        private EMarca marca = EMarca.Nada;
        private bool gradiente = false;
        private Color colorInicial = Color.White;
        private Color colorFinal = Color.Blue;
        private Image imagen;

        [Category("Action")]
        [Description("Se lanza cuando se hace clic sobre la marca")]
        public event EventHandler ClickEnMarca;

        [Category("Appearence")]
        [Description("Imagen que se mostrará en el lugar de la marca")]
        public Image Imagen
        {
            set
            {
                imagen = value;
                this.Refresh();
            }
            get { return imagen; }
        }

        [Category("Appearance")]
        [Description("Indica si se dibuja un gradiente de fondo")]
        public bool Gradiente
        {
            get { return gradiente; }
            set
            {
                gradiente = value;
                this.Refresh();
            }
        }

        [Category("Appearance")]
        [Description("Color inicial del gradiente")]
        public Color ColorInicial
        {
            get { return colorInicial; }
            set { colorInicial = value; this.Refresh(); }
        }

        [Category("Appearance")]
        [Description("Color final del gradiente")]
        public Color ColorFinal
        {
            get { return colorFinal; }
            set { colorFinal = value; this.Refresh(); }
        }

        [Category("Appearance")]
        [Description("Indica el tipo de marca que aparece junto al texto")]
        public EMarca Marca
        {
            set
            {
                marca = value;
                this.Refresh();
            }
            get
            {
                return marca;
            }
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;

            if (Gradiente && this.Width > 0 && this.Height > 0)
            {
                using (var brush = new System.Drawing.Drawing2D.LinearGradientBrush(
                    this.ClientRectangle,
                    ColorInicial,
                    ColorFinal,
                    System.Drawing.Drawing2D.LinearGradientMode.Horizontal))
                {
                    g.FillRectangle(brush, this.ClientRectangle);
                }
            }

            base.OnPaint(e);
            int grosor = 0;
            int offsetX = 0;
            int offsetY = 0;
            int h = this.Font.Height;

            switch (Marca)
            {
                case EMarca.Circulo:
                    grosor = 20;
                    offsetX = h + grosor;
                    offsetY = grosor;
                    g.DrawEllipse(new Pen(Color.Green, grosor), grosor, grosor, h, h);
                    break;
                case EMarca.Cruz:
                    grosor = 3;
                    Pen lapiz = new Pen(Color.Red, grosor);
                    g.DrawLine(lapiz, grosor, grosor, h, h);
                    g.DrawLine(lapiz, h, grosor, grosor, h);
                    offsetX = h + grosor;
                    offsetY = grosor / 2;
                    lapiz.Dispose();
                    break;
                case EMarca.Imagen:

                    grosor = 5;

                    if (imagen != null)
                    {
                        g.DrawImage(imagen, grosor, grosor, h, h);
                        offsetX = h + grosor;
                        offsetY = grosor;
                    }
                    else
                    {
                        offsetX = 0;
                        offsetY = 0;
                    }

                    break;
            }

            SolidBrush b = new SolidBrush(this.ForeColor);
            g.DrawString(this.Text, this.Font, b, offsetX + grosor, offsetY);
            Size tam = g.MeasureString(this.Text, this.Font).ToSize();
            this.Size = new Size(tam.Width + offsetX + grosor, tam.Height + offsetY * 2);
            b.Dispose();
        }

        protected override void OnTextChanged(EventArgs e)
        {
            base.OnTextChanged(e);
            this.Refresh();
        }

        protected override void OnMouseClick(MouseEventArgs e)
        {
            base.OnMouseClick(e);

            int h = this.Font.Height;
            int ajusteG = (Marca == EMarca.Circulo) ? 20 : 5;

            Rectangle rectMarca = new Rectangle(0, 0, h + (ajusteG * 2), h + (ajusteG * 2));

            if (rectMarca.Contains(e.Location))
            {
                ClickEnMarca?.Invoke(this, EventArgs.Empty);
            }
        }
    }
}
