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
    public partial class ValidateTextBox : UserControl
    {

        [Category("Tipo")]
        [Description("Elegir entre validador textual y numérico")]
        public enum ETipo
        {
            Numerico,
            Textual
        }

        private TextBox textBoxInterno = new TextBox();


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
            }
        }


        [Category("Tipo")]
        [Description("Cambiar a multilinea")]
        public bool Multilinea
        {
            get
            {
                return textBoxInterno.Multiline;
            }
            set
            {
                textBoxInterno.Multiline = value;
                this.Height = value ? 100 : textBoxInterno.Height + 20;
            }
        }



        [Category("Texto")]
        [Description("Cambia el contenido")]
        public string Texto
        {
            get
            {
                return textBoxInterno.Text;
            }
            set
            {
                textBoxInterno.Text = value;
            }
        }



        [Category("Evento")]
        [Description("Se lanza cuando el texto del textbox cambia.")]
        public EventHandler TextoChanged;

        private Color ColorBorde = Color.Red;
        public ValidateTextBox()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            using (Pen lapiz = new Pen(ColorBorde, 8))
            {
                e.Graphics.DrawRectangle(lapiz, 5, 5, this.Width - 9, this.Height - 9);
            }
        }

        private void ValidateTextBox_Load(object sender, EventArgs e)
        {
            TextBox textBox = new TextBox();
            textBox.Location = new Point(10, 10);
            textBox.Width = this.Width - 20;
            this.Height = textBox.Height + 20;
            textBoxInterno.TextChanged += (s, ev) => OnTextChanged(EventArgs.Empty);

            this.Controls.Add(textBox);
        }

        protected virtual void OnTextoChanged(EventArgs e)
        {
            TextoChanged?.Invoke(this, e);
        }
    }
}
