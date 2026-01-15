using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox.Left = (this.ClientSize.Width - textBox.Width) / 2;
            textBox.Top = (this.ClientSize.Height - textBox.Height) / 2;

            for (int i = 0; i <= 4; i++)
            {
            }
        }
    }
}
