using ejercicio2.lib;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicio2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            foreach (Control control in this.Controls)
            {
                if (control is Button btn)
                {
                    btn.MouseEnter += (s, e) => { btn.BackColor = Color.LightBlue; };
                    btn.MouseLeave += (s, e) => { btn.BackColor = SystemColors.ButtonFace; };
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                Utils utils = new Utils();

                int red = utils.CheckText(textBox1.Text);
                int green = utils.CheckText(textBox2.Text);
                int blue = utils.CheckText(textBox3.Text);

                this.BackColor = Color.FromArgb(red, green, blue);
            }
            catch (ArgumentException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string ruta = textBox4.Text;

            // C:\Users\oscar\Downloads\images.png
            pictureBox1.ImageLocation = ruta;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Estás seguro de que quieres salir?", "Mi aplicación", MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
            {
                this.Close();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            foreach (Control control in this.Controls)
            {
                if(control is TextBox txt && txt.Tag?.ToString() == "editable")
                {
                    txt.Text = null;
                }
            }

            pictureBox1.Image = null;
            this.BackColor = SystemColors.Control;
        }
    }
}
