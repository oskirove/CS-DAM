using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio4
{
    public partial class Form1 : Form
    {
        private string titulo = "Gestor de listas";
        private Timer timer;
        int cont = 0;

        public Form1()
        {
            InitializeComponent();

            timer = new Timer();
            timer.Interval = 200;
            timer.Tick += Timer_Tick;
            timer.Start();

            listBox1.SelectedIndexChanged += (s, e) => { label1.Text = "Índices: " + listBox1.SelectedIndex.ToString(); };
        }


        private void Timer_Tick(object sender, EventArgs e)
        {
            char[] letras = titulo.ToCharArray();

            if (cont < letras.Length)
            {
                this.Text += letras[cont];
                cont++;
            }
            else
            {
                cont = 0;
                this.Text = "";
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(textBox1.Text))
            {
                if (!listBox1.Items.Contains(textBox1.Text))
                {
                    string texto = textBox1.Text;
                    listBox1.Items.Add(texto);
                    label2.Text = "Contenido: " + listBox1.Items.Count.ToString();
                }
                else
                {
                    MessageBox.Show("No se pudo agregar a la lista, el contenido ya existe.", "Error al agregar el contenido", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            else
            {
                MessageBox.Show("No se pudo agregar a la lista, el campo no puede estar vacío.", "Error al agregar el contenido", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                string seleccion = listBox1.SelectedItem?.ToString();
                listBox1.Items.Remove(seleccion);
                label2.Text = "Contenido: " + listBox1.Items.Count.ToString();
            }

            if (radioButton2.Checked)
            {
                string seleccion = listBox2.SelectedItem?.ToString();
                listBox2.Items.Remove(seleccion);
                label2.Text = "Contenido: " + listBox1.Items.Count.ToString();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (radioButton3.Checked)
            {
                string seleccion = listBox1.SelectedItem?.ToString();

                if (string.IsNullOrEmpty(seleccion))
                {
                    MessageBox.Show("debes seleccionar un item de la primera lista.");
                }
                else
                {
                    listBox2.Items.Add(seleccion);
                    listBox1.Items.Remove(seleccion);
                    label2.Text = "Contenido: " + listBox1.Items.Count.ToString();
                }

            }

            if (radioButton4.Checked)
            {
                string seleccion = listBox2.SelectedItem?.ToString();

                if (string.IsNullOrEmpty(seleccion))
                {
                    MessageBox.Show("debes seleccionar un item de la segunda lista.");
                }
                else
                {
                    listBox1.Items.Add(seleccion);
                    listBox2.Items.Remove(seleccion);
                    label2.Text = "Contenido: " + listBox1.Items.Count.ToString();
                }
            }
        }

        private void tooltip_Index(object sender, EventArgs e)
        {

        }
    }
}
