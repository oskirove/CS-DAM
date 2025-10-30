namespace Ejercicio3
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form2));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.ajustarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.noDeformarToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.ajustarAlEspacioToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.noDeformarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.ContextMenuStrip = this.contextMenuStrip1;
            this.pictureBox1.Location = new System.Drawing.Point(-2, 1);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(799, 452);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(32, 32);
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ajustarToolStripMenuItem,
            this.noDeformarToolStripMenuItem1});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(301, 124);
            // 
            // ajustarToolStripMenuItem
            // 
            this.ajustarToolStripMenuItem.Name = "ajustarToolStripMenuItem";
            this.ajustarToolStripMenuItem.Size = new System.Drawing.Size(300, 38);
            this.ajustarToolStripMenuItem.Text = "Ajustar";
            this.ajustarToolStripMenuItem.Click += new System.EventHandler(this.ajustarPerfectamenteToolStripMenuItem_Click);
            // 
            // noDeformarToolStripMenuItem1
            // 
            this.noDeformarToolStripMenuItem1.Name = "noDeformarToolStripMenuItem1";
            this.noDeformarToolStripMenuItem1.Size = new System.Drawing.Size(300, 38);
            this.noDeformarToolStripMenuItem1.Text = "No deformar";
            this.noDeformarToolStripMenuItem1.Click += new System.EventHandler(this.ajustarSinDeformarToolStripMenuItem_Click);
            // 
            // ajustarAlEspacioToolStripMenuItem
            // 
            this.ajustarAlEspacioToolStripMenuItem.Name = "ajustarAlEspacioToolStripMenuItem";
            this.ajustarAlEspacioToolStripMenuItem.Size = new System.Drawing.Size(32, 19);
            // 
            // noDeformarToolStripMenuItem
            // 
            this.noDeformarToolStripMenuItem.Name = "noDeformarToolStripMenuItem";
            this.noDeformarToolStripMenuItem.Size = new System.Drawing.Size(32, 19);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.pictureBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Visor de imágenes";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem ajustarAlEspacioToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem noDeformarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ajustarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem noDeformarToolStripMenuItem1;
    }
}