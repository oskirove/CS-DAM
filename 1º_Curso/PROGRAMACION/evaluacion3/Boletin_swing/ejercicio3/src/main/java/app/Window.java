package app;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        JFrame frame = new JFrame("Mi aplicación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLayout(null);

        JButton btnYellow = new JButton("Amarillo");
        btnYellow.setBounds(298, 50, 100, 30);
        frame.add(btnYellow);

        JButton btnBlue = new JButton("Azul");
        btnBlue.setBounds(398, 50, 100, 30);
        frame.add(btnBlue);

        JButton btnRandom = new JButton("Aleatorio");
        btnRandom.setBounds(498, 50, 100, 30);
        frame.add(btnRandom);

        btnYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.YELLOW);
            }
        });

        btnBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.BLUE);
            }
        });

        btnRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((e.getModifiers() & ActionEvent.SHIFT_MASK) != 0) {

                    int altura = frame.getContentPane().getHeight();
                    int anchura = frame.getContentPane().getWidth();

                    int numerosAleatoriosShiftX[] = new int[2];
                    int numerosAleatoriosShiftY[] = new int[2];

                    for (int i = 0; i <= numerosAleatoriosShiftX.length - 1; i++) {
                        numerosAleatoriosShiftX[i] = (int) (Math.random() * anchura + 1);
                    }

                    for (int i = 0; i <= numerosAleatoriosShiftY.length - 1; i++) {
                        numerosAleatoriosShiftY[i] = (int) (Math.random() * altura + 1);
                    }

                    btnRandom.setBounds(numerosAleatoriosShiftX[0], numerosAleatoriosShiftY[1], 100, 30);

                } else {

                    int randomX = (int) (Math.random() * 601);
                    int randomY = (int) (Math.random() * 401);
                    frame.setLocation(randomX, randomY);
                }
            }
        });

        frame.setVisible(true);
    }
}
