package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.InputMismatchException;

import javax.swing.*;

public class Form extends JFrame implements ActionListener {

    private JTextField txf1;
    private JTextField txf2;
    private JTextField txf3;
    private JTextField imgPath;
    private JButton btnCoolor;
    private JLabel img;

    public Form() {
        super("Mi aplicación");
        this.setLayout(new FlowLayout());

        txf1 = new JTextField("", 3);
        txf1.setToolTipText("Introduce el valor para el canal rojo");
        this.add(txf1);

        txf2 = new JTextField("", 3);
        txf2.setToolTipText("Introduce el valor para el canal verde");
        this.add(txf2);

        txf3 = new JTextField("", 3);
        txf3.setToolTipText("Introduce el valor para el canal azul");
        this.add(txf3);

        btnCoolor = new JButton("Color");
        btnCoolor.setToolTipText("Haz clic para cambiar el color. (Ctrl + clic para cambiar el texto)");
        btnCoolor.addActionListener(this);
        this.getRootPane().setDefaultButton(btnCoolor);
        this.add(btnCoolor);

        imgPath = new JTextField("", 45);
        imgPath.addActionListener(this);
        imgPath.setToolTipText("Introduce la ruta de una imagen");
        this.add(imgPath);

        img = new JLabel();
        this.add(img);
        img.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCoolor) {
            try {
                String cadenaRojo = txf1.getText();
                String cadenaVerde = txf2.getText();
                String cadenaAzul = txf3.getText();

                if (cadenaRojo.isEmpty() || cadenaVerde.isEmpty() || cadenaAzul.isEmpty()) {
                    throw new InputMismatchException("Los campos no pueden estar vacíos.");
                }

                int rojo, verde, azul;
                try {
                    rojo = Integer.parseInt(cadenaRojo);
                    verde = Integer.parseInt(cadenaVerde);
                    azul = Integer.parseInt(cadenaAzul);
                } catch (NumberFormatException ex) {
                    throw new InputMismatchException("Los valores introducido no son correctos");
                }

                if (rojo > 255 || rojo < 0 || verde > 255 || verde < 0 || azul > 255 || azul < 0) {
                    throw new InputMismatchException("Los valores no pueden ser mayores a 255 ni menores que 0");
                }

                if (e.getSource() == btnCoolor) {
                    if ((e.getModifiers() & InputEvent.CTRL_DOWN_MASK) != 0) {
                        btnCoolor.setForeground(new Color(rojo, verde, azul));
                    } else {
                        btnCoolor.setBackground(new Color(rojo, verde, azul));
                    }
                }
            } catch (InputMismatchException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == imgPath) {
            try {
                if (imgPath.getText().isEmpty()) {
                    throw new InputMismatchException("Debes introducir una ruta para la imagen.");
                }

                File file = new File(imgPath.getText());

                if (!file.exists() || !file.isFile()) {
                    throw new InputMismatchException("La ruta no es válida o el archivo no existe.");
                }

                if (!imgPath.getText().endsWith(".png") && !imgPath.getText().endsWith(".jpeg") && !imgPath.getText().endsWith(".jpg")) {
                    throw new InputMismatchException("El formato de este archivo no es válido");
                }

                ImageIcon icon = new ImageIcon(imgPath.getText());

                img.setIcon(icon);
                img.setVisible(true);

            } catch (InputMismatchException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
