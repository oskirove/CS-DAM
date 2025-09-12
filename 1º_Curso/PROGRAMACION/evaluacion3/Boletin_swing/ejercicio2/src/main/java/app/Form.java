package app;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Form {
    public Form() {

    JFrame frame = new JFrame("Mi aplicación");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLayout(new FlowLayout());

    JLabel label = new JLabel("Introduce un texto");
    TextField textField = new TextField(20);
    JCheckBox checkBox = new JCheckBox("Dar la vuelta al texto");
    JCheckBox checkEnableText = new JCheckBox("Bloquear campo de texto");

    frame.add(label);
    frame.add(textField);
    frame.add(checkBox);
    frame.add(checkEnableText);

    textField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        int response = JOptionPane.showConfirmDialog(frame, "¿Quieres cambiar el titulo de la app por `" + text + "`?",
            "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.OK_OPTION) {
          frame.setTitle(text);
        }
      }
    });

    checkBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        String reverseText = "";
        if (checkBox.isSelected()) {
          for (int i = text.length() - 1; i >= 0; i--) {
            reverseText += text.charAt(i);
          }
          frame.setTitle(reverseText);
        } else {
          frame.setTitle(text);
        }
      }
    });

    checkEnableText.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (checkEnableText.isSelected()) {
          textField.setEnabled(false);
        } else {
          textField.setEnabled(true);
        }
      }
    });

    frame.setVisible(true);
  }
}
