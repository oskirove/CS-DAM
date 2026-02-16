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
        public enum ETipo
        {
            Numerico,
            Textual
        }

        private TextBox TextBoxInterno = new TextBox();


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

        public bool Multilinea
        {
            get
            {
                return TextBoxInterno.Multiline;
            }
            set
            {
                TextBoxInterno.Multiline = value;
                this.Height = value ? 100 : TextBoxInterno.Height + 20;
            }
        }

        public string Texto
        {
            get
            {
                return TextBoxInterno.Text;
            }
            set
            {
                TextBoxInterno.Text = value;
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
            TextBoxInterno.TextChanged += (s, ev) => OnTextChanged(EventArgs.Empty);

            this.Controls.Add(textBox);
        }

        protected virtual void OnTextoChanged(EventArgs e)
        {
            TextoChanged?.Invoke(this, e);
        }
    }
}
