using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace componente
{
    public partial class ValidateTextBox : UserControl //Cambiar color si cambia tipo. Posicion recuadro 5,5. Ajustar bien el alto.
    {

        [Category("Tipo")]
        [Description("Elegir entre validador textual y numérico")]
        public enum ETipo
        {
            Numerico,
            Textual
        }

        private ETipo etipo = ETipo.Numerico;

        public ETipo Tipo
        {
            get
            {
                return etipo;
            }
            set
            {
                etipo = value;
                this.Refresh();
            }
        }


        [Category("Tipo")]
        [Description("Cambiar a multilinea")]
        public bool Multilinea
        {
            get
            {
                return textBox1.Multiline;
            }
            set
            {
                textBox1.Multiline = value;
                this.Height = value ? 100 : textBox1.Height + 20;
                this.Refresh();
            }
        }



        [Category("Texto")]
        [Description("Cambia el contenido")]
        public string Texto
        {
            get
            {
                return textBox1.Text;
            }
            set
            {
                textBox1.Text = value;
                this.Refresh();
            }
        }

        [Category("Evento")]
        [Description("Se lanza cuando el texto del textbox cambia.")]
        public EventHandler TextoChanged;

        private Color colorBorde = Color.Transparent;
        public ValidateTextBox()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            using (Pen lapiz = new Pen(colorBorde, 4))
            {
                e.Graphics.DrawRectangle(lapiz, 5, 5, this.Width - 10, this.Height - 10);
            }
        }

        private void ValidateTextBox_Load(object sender, EventArgs e)
        {
            textBox1.Location = new Point(10, 10);
            textBox1.Width = this.Width - 20;
            this.Height = textBox1.Height + 20;

            textBox1.TextChanged += (s, ev) => OnTextChanged(EventArgs.Empty);
        }

        protected virtual void OnTextoChanged(EventArgs e)
        {
            TextoChanged?.Invoke(this, e);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            string texto = textBox1.Text;

            if (string.IsNullOrEmpty(texto))
            {
                colorBorde = Color.Red;
            }
            else
            {
                switch (etipo)
                {
                    case ETipo.Numerico:

                        string textoProcesado = texto.Trim();

                        if (textoProcesado.Length > 0 && textoProcesado.All(char.IsDigit))
                        {
                            colorBorde = Color.Green;
                        }
                        else
                        {
                            colorBorde = Color.Red;
                        }

                        break;
                    case ETipo.Textual:

                        if (texto.All(c => char.IsLetter(c) || c == ' '))
                        {
                            colorBorde = Color.Green;
                        }
                        else
                        {
                            colorBorde = Color.Red;
                        }

                        break;
                }
            }

            this.Refresh();
        }

        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            textBox1.Width = this.Width - 20;
            this.Height = textBox1.Height + 20;
        }
    }
}
