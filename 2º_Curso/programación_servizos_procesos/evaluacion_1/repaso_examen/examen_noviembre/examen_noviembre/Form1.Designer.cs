namespace examen_noviembre
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lb = new System.Windows.Forms.ListBox();
            this.panel = new System.Windows.Forms.Panel();
            this.btnAñadir = new System.Windows.Forms.Button();
            this.txtDatos = new System.Windows.Forms.TextBox();
            this.gbAcciones = new System.Windows.Forms.GroupBox();
            this.rbMostrar = new System.Windows.Forms.RadioButton();
            this.rbEliminar = new System.Windows.Forms.RadioButton();
            this.gbAcciones.SuspendLayout();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.FormattingEnabled = true;
            this.lb.ItemHeight = 25;
            this.lb.Location = new System.Drawing.Point(55, 45);
            this.lb.Name = "lb";
            this.lb.SelectionMode = System.Windows.Forms.SelectionMode.MultiSimple;
            this.lb.Size = new System.Drawing.Size(302, 379);
            this.lb.TabIndex = 0;
            this.lb.SelectedIndexChanged += new System.EventHandler(this.lb_SelectedIndexChanged);
            // 
            // panel
            // 
            this.panel.AutoScroll = true;
            this.panel.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel.Location = new System.Drawing.Point(730, 45);
            this.panel.Name = "panel";
            this.panel.Size = new System.Drawing.Size(388, 379);
            this.panel.TabIndex = 1;
            // 
            // btnAñadir
            // 
            this.btnAñadir.Location = new System.Drawing.Point(55, 448);
            this.btnAñadir.Name = "btnAñadir";
            this.btnAñadir.Size = new System.Drawing.Size(302, 71);
            this.btnAñadir.TabIndex = 2;
            this.btnAñadir.Text = "Añadir";
            this.btnAñadir.UseVisualStyleBackColor = true;
            this.btnAñadir.Click += new System.EventHandler(this.btnAñadir_Click);
            // 
            // txtDatos
            // 
            this.txtDatos.Location = new System.Drawing.Point(392, 45);
            this.txtDatos.Multiline = true;
            this.txtDatos.Name = "txtDatos";
            this.txtDatos.ReadOnly = true;
            this.txtDatos.Size = new System.Drawing.Size(302, 379);
            this.txtDatos.TabIndex = 3;
            // 
            // gbAcciones
            // 
            this.gbAcciones.Controls.Add(this.rbMostrar);
            this.gbAcciones.Controls.Add(this.rbEliminar);
            this.gbAcciones.Location = new System.Drawing.Point(392, 448);
            this.gbAcciones.Name = "gbAcciones";
            this.gbAcciones.Size = new System.Drawing.Size(305, 173);
            this.gbAcciones.TabIndex = 4;
            this.gbAcciones.TabStop = false;
            this.gbAcciones.Text = "Acciones ( A )";
            // 
            // rbMostrar
            // 
            this.rbMostrar.AutoSize = true;
            this.rbMostrar.Location = new System.Drawing.Point(20, 116);
            this.rbMostrar.Name = "rbMostrar";
            this.rbMostrar.Size = new System.Drawing.Size(116, 29);
            this.rbMostrar.TabIndex = 1;
            this.rbMostrar.TabStop = true;
            this.rbMostrar.Text = "Mostrar";
            this.rbMostrar.UseVisualStyleBackColor = true;
            // 
            // rbEliminar
            // 
            this.rbEliminar.AutoSize = true;
            this.rbEliminar.Location = new System.Drawing.Point(20, 58);
            this.rbEliminar.Name = "rbEliminar";
            this.rbEliminar.Size = new System.Drawing.Size(120, 29);
            this.rbEliminar.TabIndex = 0;
            this.rbEliminar.TabStop = true;
            this.rbEliminar.Text = "Eliminar";
            this.rbEliminar.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1173, 677);
            this.Controls.Add(this.gbAcciones);
            this.Controls.Add(this.txtDatos);
            this.Controls.Add(this.btnAñadir);
            this.Controls.Add(this.panel);
            this.Controls.Add(this.lb);
            this.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Form1_KeyPress);
            this.gbAcciones.ResumeLayout(false);
            this.gbAcciones.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lb;
        private System.Windows.Forms.Panel panel;
        private System.Windows.Forms.Button btnAñadir;
        private System.Windows.Forms.TextBox txtDatos;
        private System.Windows.Forms.GroupBox gbAcciones;
        private System.Windows.Forms.RadioButton rbMostrar;
        private System.Windows.Forms.RadioButton rbEliminar;
    }
}

