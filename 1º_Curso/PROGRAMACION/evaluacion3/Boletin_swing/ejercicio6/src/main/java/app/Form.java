package app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.Excepciones.IfIsNotEmptyOrNull;

public class Form extends JFrame implements ActionListener {

    private JTextField txf1;
    private JTextField txf2;
    private JLabel lbl;
    private JButton btnSuma;
    private JButton btnRaizCuadrada;
    private JButton btnDivision;

    public Form() {
        super("Mi aplicación");
        this.setLayout(new FlowLayout());

        txf1 = new JTextField("", 3);
        this.add(txf1);

        txf2 = new JTextField("", 3);
        this.add(txf2);

        lbl = new JLabel();
        this.add(lbl);

        btnSuma = new JButton("+");
        btnSuma.addActionListener(this);
        this.add(btnSuma);

        btnRaizCuadrada = new JButton("√");
        btnRaizCuadrada.addActionListener(this);
        this.add(btnRaizCuadrada);

        btnDivision = new JButton("÷");
        btnDivision.addActionListener(this);
        this.add(btnDivision);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSuma) {
            try {
                if (txf1.getText().isEmpty() || txf2.getText().isEmpty()) {
                    throw new InputMismatchException("Los campos no pueden estar vacios");
                }

                String valor1 = txf1.getText();
                String valor2 = txf2.getText();
                Boolean esNumero = true;

                try {
                    Double.parseDouble(valor1);
                    Double.parseDouble(valor2);
                } catch (NumberFormatException ex) {
                    esNumero = false;
                }

                if (!esNumero) {
                    throw new NumberFormatException(
                            "Debes introducir valores numéricos");
                }

                double n1 = Double.parseDouble(txf1.getText());
                double n2 = Double.parseDouble(txf2.getText());

                Double resultado = n1 + n2;
                String cadena = String.format("%.2f", resultado);

                lbl.setText(cadena);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == btnRaizCuadrada) {
            try {
                if (!txf2.getText().isEmpty()) {
                    throw new IfIsNotEmptyOrNull("El campo de la derecha debe estar vacío");
                }

                String valor = txf1.getText();
                boolean esNumero = true;

                try {
                    Double.parseDouble(valor);
                } catch (NumberFormatException ex) {
                    esNumero = false;
                }

                if (!esNumero) {
                    throw new NumberFormatException(
                            "Debes introducir valores numéricos");
                }

                Double resultado = Math.sqrt(Double.parseDouble(txf1.getText()));

                String cadena = String.format("%.2f", resultado);

                lbl.setText(cadena);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            try {
                if (txf1.getText().isEmpty() || txf2.getText().isEmpty()) {
                    throw new InputMismatchException("Los campos no pueden estar vacios");
                }

                String valor1 = txf1.getText();
                String valor2 = txf2.getText();
                Boolean esNumero = true;

                try {
                    Double.parseDouble(valor1);
                    Double.parseDouble(valor2);
                } catch (NumberFormatException ex) {
                    esNumero = false;
                }

                if (!esNumero) {
                    throw new NumberFormatException(
                            "Debes introducir valores numéricos");
                }

                double n1 = Double.parseDouble(txf1.getText());
                double n2 = Double.parseDouble(txf2.getText());

                Double resultado = n1 / n2;
                String cadena = String.format("%.2f", resultado);

                lbl.setText(cadena);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
