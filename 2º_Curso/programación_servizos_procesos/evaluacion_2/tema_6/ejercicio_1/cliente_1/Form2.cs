using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_1
{
    public partial class Form2 : Form//Revisar comprobacion ip y puerto. No excep genérica.
    {
        public IPAddress ip { get; private set; }
        public int port { get; private set; }

        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int.TryParse(tbPort.Text, out int puerto);
            
            if (string.IsNullOrEmpty(tbIp.Text) || string.IsNullOrEmpty(tbPort.Text))
            {
                MessageBox.Show("Los campos no pueden estar vacíos", "Advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                ip = IPAddress.Parse(tbIp.Text);
                port = puerto;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
