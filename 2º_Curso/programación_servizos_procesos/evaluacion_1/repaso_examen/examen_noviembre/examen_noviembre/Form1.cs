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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            lb.Items.Add(new Recetas("Tortilla", "Tortilla de patatas", 40));
            lb.Items.Add(new Recetas("Rissotto", "Rissotto de champiñones", 30));
            lb.Items.Add(new Recetas("Gazpacho", "Gazpacho andaluz", 20));
            this.KeyPreview = true;
        }

        private void btnAñadir_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2();
            f.ShowDialog();

            if (f.DialogResult == DialogResult.Yes)
            {
                lb.Items.Add(f.Receta);
            }
            else if (f.DialogResult == DialogResult.No)
            {
                f.Hide();
            }
        }

        private void lb_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtDatos.ResetText();

            for (int i = 0; i < lb.SelectedItems.Count; i++)
            {
                Recetas receta = (Recetas)lb.SelectedItems[i];
                txtDatos.Text += $"{receta.Nombre,10} {receta.Tiempo,5} {Environment.NewLine} {receta.Descripcion} {Environment.NewLine} {Environment.NewLine}";
            }
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == 'a' && rbEliminar.Checked)
            {
                for (int i = lb.SelectedIndices.Count - 1; i >= 0; i--)
                {
                    lb.Items.RemoveAt(lb.SelectedIndices[i]);
                }
            }
            else if (e.KeyChar == 'a' && rbMostrar.Checked)
            {
                panel.Controls.Clear();

                int y = 10;

                for (int i = 0; i < lb.SelectedItems.Count; i++)
                {
                    Recetas receta = (Recetas)lb.SelectedItems[i];

                    Label lbl = new Label();
                    lbl.Text = receta.Nombre;
                    lbl.Location = new Point(10, y);
                    lbl.AutoSize = true;

                    lbl.MouseEnter += (send, ev) =>
                    {
                        Label lblHover = send as Label;
                        lblHover.Text = receta.Tiempo.ToString() + " minutos";
                    };

                    lbl.MouseLeave += (send, ev) =>
                    {
                        Label lblHover = send as Label;
                        lblHover.Text = receta.Nombre;
                    };

                    panel.Controls.Add(lbl);

                    y += 25;
                }

                
            }
        }
    }
}
