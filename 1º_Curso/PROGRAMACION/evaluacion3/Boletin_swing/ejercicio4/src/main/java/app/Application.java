
package app;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    MainForm form = new MainForm();
    form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    form.setSize(900, 800);
    form.setVisible(true);
  }
}
