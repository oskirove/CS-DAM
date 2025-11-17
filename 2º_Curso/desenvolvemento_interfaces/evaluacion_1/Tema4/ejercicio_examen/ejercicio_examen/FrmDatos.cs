using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio_examen
{
    public partial class FrmDatos : Form
    {
        public FrmDatos()
        {
            InitializeComponent();
        }

        private void FrmDatos_Load(object sender, EventArgs e)
        {
            ComboBox cBox = new ComboBox();
            cBox.Text = "Edad";
            cBox.Left = 29;
            cBox.Top = 83;

            for (int i = 18; i <= 100; i++)
            {
                cBox.Items.Add($"{i} Años");
            }

            this.Controls.Add(cBox);
        }
    }
}
