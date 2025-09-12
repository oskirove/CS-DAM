package app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Form extends JFrame implements ActionListener {

    private JTextField txf1;
    private JTextField txf2;
    private JTextField txf3;
    private JButton btn;
    private JLabel lbl;
    private JLabel time;

    public Form() {
        super("Mi aplicación");
        this.setLayout(new FlowLayout());

        txf1 = new JTextField("", 2);
        txf1.setEnabled(false);
        this.add(txf1);

        txf2 = new JTextField("", 2);
        txf2.setEnabled(false);
        this.add(txf2);

        txf3 = new JTextField("", 2);
        txf3.setEnabled(false);
        this.add(txf3);

        btn = new JButton("Jugar");
        btn.addActionListener(this);
        this.add(btn);

        lbl = new JLabel();
        this.add(lbl);

        time = new JLabel();
        this.add(time);

        Timer timer = new Timer(1000, new ActionListener() {
            private long inicio = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {
                long milisegundosTranscurridos = System.currentTimeMillis() - inicio;
                long segundos = (milisegundosTranscurridos / 1000) % 60;
                long minutos = (milisegundosTranscurridos / 1000) / 60;
                time.setText(String.format("%02d:%02d", minutos, segundos));
            }
        });

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            Integer[] random = new Integer[3];

            for (int i = 0; i < random.length; i++) {
                random[i] = (int) (Math.random() * 6) + 1;
            }

            txf1.setText(random[0].toString());
            txf2.setText(random[1].toString());
            txf3.setText(random[2].toString());

            if (random[0] == random[1] && random[0] == random[2]) {
                lbl.setText("Has ganado");
            } else {
                lbl.setText("Has perdido");
            }
        }
    }

}
