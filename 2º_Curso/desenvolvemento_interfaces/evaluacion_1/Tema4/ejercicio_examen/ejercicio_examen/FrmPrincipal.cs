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
    public partial class FrmPrincipal : Form
    {
        private Timer timer = new Timer();
        private int index = 0;
        private int seleccionados = 0;

        public FrmPrincipal()
        {
            InitializeComponent();
            timer.Interval = 300;
            timer.Tick += Timer_Tick;
            timer.Start();
            resetToolStripMenuItem.Click += btnReset_Click;
            salirToolStripMenuItem.Click += btnExit_Click;
            this.FormClosing += FrmPrincipal_FormClosing;
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            btnPlay.BackColor = Color.Beige;
            btnReset.BackColor = Color.Beige;
            btnExit.BackColor = Color.Beige;

            switch (index)
            {
                case 0:
                    btnPlay.BackColor = Color.Yellow;
                    break;
                case 1:
                    btnReset.BackColor = Color.Yellow;
                    break;
                case 2:
                    btnExit.BackColor = Color.Yellow;
                    break;
            }

            index++;

            if (index > 2)
            {
                index = 0;
            }
        }

        private void FrmPrincipal_Load(object sender, EventArgs e)
        {
            int startX = 30;
            int startY = 30;
            int size = 40;
            int columnas = 9;

            int spacing = 40;
            int totalCB = 53;

            ToolTip toolTip = new ToolTip();

            for (int i = 0; i <= totalCB; i++)
            {
                int fila = i / columnas;
                int col = i % columnas;

                CheckBox cb = new CheckBox();

                toolTip.SetToolTip(cb, "No marcado");

                cb.BackColor = SystemColors.Window;
                cb.Text = i.ToString();
                cb.Width = size;
                cb.Height = size;
                cb.TextAlign = ContentAlignment.MiddleCenter;

                cb.Left = startX + col * spacing;
                cb.Top = startY + fila * spacing;

                this.Controls.Add(cb);

                cb.CheckedChanged += (s, ev) =>
                {
                    if (cb.Checked)
                    {
                        toolTip.SetToolTip(cb, "Marcado");
                    }
                    else
                    {
                        toolTip.SetToolTip(cb, "No marcado");
                    }
                };

                cb.CheckedChanged += CheckBox_CheckedChanged;
            }
        }

        private void CheckBox_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            int limiteSeleccionados = 6;

            if (cb.Checked)
            {
                seleccionados++;
            }
            else
            {
                seleccionados--;
            }

            if (seleccionados >= limiteSeleccionados)
            {
                foreach (Control control in Controls)
                {
                    if (control is CheckBox)
                    {
                        CheckBox chk = (CheckBox)control;
                        chk.Enabled = false;
                    }
                }
                MessageBox.Show("No puedes seleccionar mas de 6 números", "Error", MessageBoxButtons.OK);
            }
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            foreach (Control control in Controls)
            {
                if (control is CheckBox)
                {
                    CheckBox cb = (CheckBox)control;
                    cb.Checked = false;
                    cb.BackColor = SystemColors.Window;
                    cb.Enabled = true;
                }
            }

            label1.Text = "Resultados: ";
        }

        private void FrmPrincipal_FormClosing(object sender, FormClosingEventArgs e)
        {


            if (LstNombres.Items.Count > 0)
            {
                DialogResult result = MessageBox.Show("¿Estás seguro de que deseas salir?", this.Text, MessageBoxButtons.OKCancel, MessageBoxIcon.Question);

                if (result != DialogResult.OK)
                {
                    e.Cancel = true;
                }
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {

            if (LstNombres.Items.Count > 0)
            {
                DialogResult result = MessageBox.Show("Se saldrá de la aplicación", this.Text, MessageBoxButtons.OKCancel, MessageBoxIcon.Exclamation);

                if (result == DialogResult.OK)
                {
                    this.Close();
                }
            }
            else
            {
                this.Close();
            }
        }

        private void btnPlay_Click(object sender, EventArgs e)
        {
            if (seleccionados < 6)
            {
                MessageBox.Show("Debes seleccionar al menos 6 números", "Error", MessageBoxButtons.OK);
            }
            else
            {
                int[] numeros = Generar_Numeros();

                label1.Text = $"Resultados: {string.Join(", ", numeros)}";

                foreach (Control control in this.Controls)
                {
                    if (control is CheckBox cb && cb.Checked)
                    {
                        int valor;
                        if (int.TryParse(cb.Text, out valor) && numeros.Contains(valor))
                        {
                            cb.BackColor = Color.Green;
                        }
                        else
                        {
                            cb.BackColor = Color.Red;
                        }
                    }
                }
            }
        }

        private int[] Generar_Numeros()
        {
            Random rand = new Random();
            HashSet<int> numeros = new HashSet<int>();

            while (numeros.Count < 6)
            {
                int numero = rand.Next(1, 54);
                numeros.Add(numero);
            }

            return numeros.ToArray();
        }
    }
}
