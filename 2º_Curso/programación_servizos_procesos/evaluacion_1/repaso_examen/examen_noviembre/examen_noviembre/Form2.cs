using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace examen_noviembre
{
    public partial class Form2 : Form
    {

        public Recetas Receta { private set; get; }

        public Form2()
        {
            InitializeComponent();
            for (int i = 5; i <= 60; i+=5)
            {
                cbTiempo.Items.Add($"{i,2} minutos");
            }
            cbTiempo.SelectedIndex = 3;
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            int.TryParse(cbTiempo.SelectedItem.ToString().Split(' ')[0], out int tiempo);

            Receta = new Recetas(txtNombre.Text.Trim(), txtDescripcion.Text.Trim(), tiempo);
            DialogResult = DialogResult.Yes;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.No;
        }
    }
}