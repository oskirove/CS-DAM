package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Application {//TODO estructuración en clases. DEbe funcionar el enter en txf
  public static void main(String[] args) {
    JFrame frame = new JFrame("Aplicación dado");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setLayout(new FlowLayout());


    JLabel label = new JLabel("Genera un número aleatorio entre 1 y el número que introduzcas");
    frame.add(label);
    JTextField textField = new JTextField(10);
    frame.add(textField);
    JButton button = new JButton("Lanzar dado");
    frame.add(button);
    JLabel result = new JLabel();
    frame.add(result);

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        int maxRange = 6;

        try {

          String inputValue = textField.getText();
          maxRange = Integer.parseInt(inputValue);

          if (maxRange <= 1) {
            maxRange = 6;
          }
          
        } catch (NumberFormatException ex) {
          maxRange = 6;
        }

        int randomNumber = (int) (Math.random() * maxRange) + 1;
        result.setText("Resultado " + randomNumber);
      }
    });

    frame.setVisible(true);
  }
}
