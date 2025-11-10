using Ejercicio5.lib;
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
    public partial class Form2 : Form
    {
        private string tel;
        public Form2(string tel)
        {
            InitializeComponent();
            this.tel = tel;
        }

        private void acceptButton_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBox1.Text))
            {
                MessageBox.Show("El campo nombre no puede estar vacío", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                try
                {
                    Form1 f = new Form1();

                    Utils utils = new Utils();

                    utils.addContactToFile(textBox1.Text, tel);
                    this.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("No se ha podido completar la acción, vuelve a intentarlo de nuevo.", "Error al agregar contacto", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
    }
}
