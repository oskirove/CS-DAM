using ejercicio3.lib;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            string fileName = textBox1.Text;
            Utils utils = new Utils();

            Random rnd = new Random();

            int delay = rnd.Next(1, 10);

            Task<string> task1 = utils.downloadFileAsync(fileName, delay);
        }
    }
}
