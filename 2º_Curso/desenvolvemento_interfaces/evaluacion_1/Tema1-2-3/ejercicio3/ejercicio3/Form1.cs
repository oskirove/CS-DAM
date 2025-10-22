#define PRUEBA

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

        private int credit = 50;
        private Random rnd = new Random();

        public Form1()
        {
            InitializeComponent();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void creditos_Click(object sender, EventArgs e)
        {

        }

        private void premio_Click(object sender, EventArgs e)
        {

        }

        private (int, int, int) randomNumbers(int min, int max)
        {

            int r1 = rnd.Next(min, max + 1);
            int r2 = rnd.Next(min, max + 1);
            int r3 = rnd.Next(min, max + 1);

            return (r1, r2, r3);
        }

        private void play_Click(object sender, EventArgs e)
        {
            var (n1, n2, n3) = randomNumbers(1, 7);

            textBox1.Text = n1.ToString();
            textBox2.Text = n2.ToString();
            textBox3.Text = n3.ToString();

            premio.Text = "Info";

            credit -= 2;

            creditos.Text = credit.ToString();

            if (n1 == n2 && n1 == n3)
            {
                premio.Text = "Has ganado 20 creditos";
                credit += 20;
            }
            else if (n1 == n2 || n1 == n3 || n2 == n3)
            {
                #if PRUEBA

                premio.Text = "Has perdido 5 creditos";
                credit -= 5;

                #else

                premio.Text = "Has ganado 5 creditos";
                credit += 5;

                #endif
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            credit += 10;
            creditos.Text = credit.ToString();
        }
    }
}
