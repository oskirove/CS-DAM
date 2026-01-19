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
    public partial class Form2 : Form
    {
        public IPAddress ip { get; private set; }
        public int port { get; private set; }

        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            bool trigger = int.TryParse(tbPort.Text, out int puerto);
            
            if (string.IsNullOrEmpty(tbIp.Text))
            {
                MessageBox.Show("Revisa la IP introducida", "Advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                ip = IPAddress.Parse(tbIp.Text);
            }

            if (!trigger)
            {
                MessageBox.Show("Revisa el puerto introducido", "Advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                port = puerto;
            }

            this.DialogResult = DialogResult.OK;
        }
    }
}
