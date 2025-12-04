namespace formPrueba
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
            this.labelTextbox1 = new ejercicio1.LabelTextbox();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelTextbox1
            // 
            this.labelTextbox1.Location = new System.Drawing.Point(177, 137);
            this.labelTextbox1.Name = "labelTextbox1";
            this.labelTextbox1.Posicion = ejercicio1.LabelTextbox.EPosicion.IZQUIERDA;
            this.labelTextbox1.Separacion = 0;
            this.labelTextbox1.Size = new System.Drawing.Size(395, 31);
            this.labelTextbox1.TabIndex = 0;
            this.labelTextbox1.TextLbl = "LabelTextbox";
            this.labelTextbox1.TextTxt = "";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(177, 193);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(395, 55);
            this.button1.TabIndex = 1;
            this.button1.Text = "Cambiar posición";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.labelTextbox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private ejercicio1.LabelTextbox labelTextbox1;
        private System.Windows.Forms.Button button1;
    }
}

