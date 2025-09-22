namespace ejercicio3
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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.play = new System.Windows.Forms.Button();
            this.creditos = new System.Windows.Forms.Label();
            this.premio = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(215, 178);
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.Size = new System.Drawing.Size(100, 31);
            this.textBox1.TabIndex = 0;
            this.textBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(347, 178);
            this.textBox2.Name = "textBox2";
            this.textBox2.ReadOnly = true;
            this.textBox2.Size = new System.Drawing.Size(100, 31);
            this.textBox2.TabIndex = 1;
            this.textBox2.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(476, 178);
            this.textBox3.Name = "textBox3";
            this.textBox3.ReadOnly = true;
            this.textBox3.Size = new System.Drawing.Size(100, 31);
            this.textBox3.TabIndex = 2;
            this.textBox3.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // play
            // 
            this.play.Location = new System.Drawing.Point(306, 287);
            this.play.Name = "play";
            this.play.Size = new System.Drawing.Size(191, 71);
            this.play.TabIndex = 3;
            this.play.Text = "Jugar";
            this.play.UseVisualStyleBackColor = true;
            this.play.Click += new System.EventHandler(this.play_Click);
            // 
            // creditos
            // 
            this.creditos.AutoSize = true;
            this.creditos.Location = new System.Drawing.Point(652, 181);
            this.creditos.Name = "creditos";
            this.creditos.Size = new System.Drawing.Size(36, 25);
            this.creditos.TabIndex = 4;
            this.creditos.Text = "50";
            this.creditos.Click += new System.EventHandler(this.creditos_Click);
            // 
            // premio
            // 
            this.premio.AutoSize = true;
            this.premio.Location = new System.Drawing.Point(365, 66);
            this.premio.Name = "premio";
            this.premio.Size = new System.Drawing.Size(70, 25);
            this.premio.TabIndex = 5;
            this.premio.Text = "label1";
            this.premio.Click += new System.EventHandler(this.premio_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(600, 265);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(148, 115);
            this.button1.TabIndex = 6;
            this.button1.Text = "Recargar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(817, 461);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.premio);
            this.Controls.Add(this.creditos);
            this.Controls.Add(this.play);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Button play;
        private System.Windows.Forms.Label creditos;
        private System.Windows.Forms.Label premio;
        private System.Windows.Forms.Button button1;
    }
}

