using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio5
{
    public partial class Form3 : Form
    {
        public Form3(List<string> contactos)
        {
            InitializeComponent();
            textBox1.Font = new Font("Consolas", 10);

            StringBuilder sb = new StringBuilder();

            foreach (string contacto in contactos)
            {
                string[] partes = contacto.Split(':');
                string nombre = partes[0].Trim();
                string telefono = partes.Length > 1 ? partes[1].Trim() : "";

                sb.AppendLine($"{nombre,-20} {telefono,9}");
            }

            textBox1.Text = sb.ToString();
        }
    }
}
