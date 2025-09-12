
package app;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    Form ventana = new Form();
    ventana.setSize(700, 600);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setVisible(true);
  }
}
