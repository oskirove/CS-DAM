namespace cliente_1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.tbContraseña = new System.Windows.Forms.TextBox();
            this.lblContraseña = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.lblIP = new System.Windows.Forms.Label();
            this.lblPort = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // tbContraseña
            // 
            this.tbContraseña.Location = new System.Drawing.Point(159, 135);
            this.tbContraseña.Name = "tbContraseña";
            this.tbContraseña.Size = new System.Drawing.Size(460, 31);
            this.tbContraseña.TabIndex = 0;
            // 
            // lblContraseña
            // 
            this.lblContraseña.AutoSize = true;
            this.lblContraseña.Location = new System.Drawing.Point(323, 107);
            this.lblContraseña.Name = "lblContraseña";
            this.lblContraseña.Size = new System.Drawing.Size(123, 25);
            this.lblContraseña.TabIndex = 1;
            this.lblContraseña.Text = "Contraseña";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(159, 229);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(460, 90);
            this.button1.TabIndex = 2;
            this.button1.Text = "Configuración";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // lblIP
            // 
            this.lblIP.AutoSize = true;
            this.lblIP.Location = new System.Drawing.Point(154, 35);
            this.lblIP.Name = "lblIP";
            this.lblIP.Size = new System.Drawing.Size(133, 25);
            this.lblIP.TabIndex = 3;
            this.lblIP.Text = "IP: 127.0.0.1";
            // 
            // lblPort
            // 
            this.lblPort.AutoSize = true;
            this.lblPort.Location = new System.Drawing.Point(484, 35);
            this.lblPort.Name = "lblPort";
            this.lblPort.Size = new System.Drawing.Size(135, 25);
            this.lblPort.TabIndex = 4;
            this.lblPort.Text = "Puerto: 4321";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(810, 459);
            this.Controls.Add(this.lblPort);
            this.Controls.Add(this.lblIP);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.lblContraseña);
            this.Controls.Add(this.tbContraseña);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Cliente";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbContraseña;
        private System.Windows.Forms.Label lblContraseña;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label lblIP;
        private System.Windows.Forms.Label lblPort;
    }
}

