namespace Formulario
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
            this.miniReproductor1 = new mini_reproductor.MiniReproductor();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnFolder = new System.Windows.Forms.Button();
            this.cbSeconds = new System.Windows.Forms.ComboBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // miniReproductor1
            // 
            this.miniReproductor1.IsPlaying = false;
            this.miniReproductor1.Location = new System.Drawing.Point(251, 231);
            this.miniReproductor1.minutes = 0;
            this.miniReproductor1.Name = "miniReproductor1";
            this.miniReproductor1.seconds = 0;
            this.miniReproductor1.Size = new System.Drawing.Size(197, 179);
            this.miniReproductor1.TabIndex = 0;
            this.miniReproductor1.PlayClick += new System.EventHandler(this.miniReproductor1_PlayClick);
            this.miniReproductor1.DesbordaTiempo += new System.EventHandler(this.miniReproductor1_DesbordaTiempo);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Location = new System.Drawing.Point(108, 33);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(508, 192);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            // 
            // btnFolder
            // 
            this.btnFolder.Location = new System.Drawing.Point(51, 310);
            this.btnFolder.Name = "btnFolder";
            this.btnFolder.Size = new System.Drawing.Size(143, 50);
            this.btnFolder.TabIndex = 2;
            this.btnFolder.Text = "Archivo";
            this.btnFolder.UseVisualStyleBackColor = true;
            this.btnFolder.Click += new System.EventHandler(this.btnFolder_Click);
            // 
            // cbSeconds
            // 
            this.cbSeconds.FormattingEnabled = true;
            this.cbSeconds.Location = new System.Drawing.Point(516, 320);
            this.cbSeconds.Name = "cbSeconds";
            this.cbSeconds.Size = new System.Drawing.Size(139, 33);
            this.cbSeconds.TabIndex = 3;
            this.cbSeconds.Text = "Segundos";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(737, 412);
            this.Controls.Add(this.cbSeconds);
            this.Controls.Add(this.btnFolder);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.miniReproductor1);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private mini_reproductor.MiniReproductor miniReproductor1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnFolder;
        private System.Windows.Forms.ComboBox cbSeconds;
    }
}

