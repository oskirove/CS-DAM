package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.swing.*;

public class MainForm extends JFrame implements ActionListener {

    private JLabel txtNombre;
    private JLabel txtEdad;
    private JLabel txtDir;
    private JTextField txfNombre;
    private JTextField txfEdad;
    private JTextField txfDir;
    private JButton btnGuardar;
    private JButton btnCargar;

    public MainForm() {
        super("Mi aplicación");
        this.setLayout(null);

        txtNombre = new JLabel("Introduce tu nombre");
        txtNombre.setBounds(20, 5, 200, 30);
        this.add(txtNombre);

        txfNombre = new JTextField();
        txfNombre.setBounds(20, 30, 200, 30);
        txfNombre.addActionListener(this);
        this.add(txfNombre);

        txtEdad = new JLabel("Introduce tu edad");
        txtEdad.setBounds(20, 65, 200, 30);
        this.add(txtEdad);

        txfEdad = new JTextField();
        txfEdad.setBounds(20, 90, 200, 30);
        //txfEdad.addActionListener(this);
        this.add(txfEdad);

        txtDir = new JLabel("Introduce tu dirección");
        txtDir.setBounds(20, 125, 200, 30);
        this.add(txtDir);

        txfDir = new JTextField();
        txfDir.setBounds(20, 150, 200, 30);
      //  txfDir.addActionListener(this);
        this.add(txfDir);

        JButton BtnGuardar = new JButton("Guardar");
        BtnGuardar.setBounds(20, 190, 95, 30);
        BtnGuardar.addActionListener(this);
        this.add(BtnGuardar);

        JButton BtnCargar = new JButton("Cargar");
        BtnCargar.setBounds(123, 190, 95, 30);
        BtnCargar.addActionListener(this);
        this.add(BtnCargar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand().toLowerCase();

        if ("Guardar".toLowerCase().equals(comando)) {// getSource
            try {
                String nombre = txfNombre.getText().trim();
                String edad = txfEdad.getText().trim();
                String dir = txfDir.getText();

                if (nombre.isEmpty()) {
                    throw new InputMismatchException("El campo NOMBRE no puede estar vacío");
                }

                if (edad.isEmpty()) {
                    throw new InputMismatchException("El campo EDAD no puede estar vacío");
                }

                if (!edad.matches("\\d+")) {
                    throw new InputMismatchException("Debes introducir un número válido en el campo EDAD!");
                }

                if (dir.isEmpty()) {
                    throw new InputMismatchException("El campo DIRECCIÓN no puede estar vacío");
                }

                try {
                    FileWriter f = new FileWriter("datos");

                    f.write("Nombre: " + nombre + "\n");
                    f.write("Edad: " + edad + "\n");
                    f.write("Dirección: " + dir + "\n");

                    f.close();
                } catch (IOException ioEx) {
                    JOptionPane.showMessageDialog(this, "No se ha podido guardar el archivo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (InputMismatchException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);

            }
        } else if ("Cargar".toLowerCase().equals(comando)) {
            try {

                FileReader r = new FileReader("datos");//TODO Scanner
                int c;
                StringBuilder sb = new StringBuilder();

                while ((c = r.read()) != -1) {
                    sb.append((char) c);
                }

                r.close();

                JOptionPane.showMessageDialog(this, sb.toString(), "Contenido del archivo",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {//TODO excepción no genérica    
                JOptionPane.showMessageDialog(this, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
