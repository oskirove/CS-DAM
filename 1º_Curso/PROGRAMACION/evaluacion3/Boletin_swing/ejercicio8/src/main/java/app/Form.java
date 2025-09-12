package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Form extends JFrame implements ActionListener {

    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel tokens;
    private JLabel win;
    private JButton play;

    private Double creditos = 10.0;
    private String titulo = "SuperMinitragaPerras";
    private int indice = 0;

    public Form() {

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelPlay = new JPanel();
        panelLabels.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelLabels.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));

        JPanel winPanel = new JPanel();
        winPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        winPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));

        ImageIcon iconoOriginal = new ImageIcon("src/main/java/app/iconos/1.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        lbl1 = new JLabel();
        lbl1.setIcon(new ImageIcon(imagenRedimensionada));
        panelLabels.add(lbl1);

        lbl2 = new JLabel();
        lbl2.setIcon(new ImageIcon(imagenRedimensionada));
        panelLabels.add(lbl2);

        lbl3 = new JLabel();
        lbl3.setIcon(new ImageIcon(imagenRedimensionada));
        panelLabels.add(lbl3);

        this.add(panelLabels);

        play = new JButton("Jugar");
        play.setAlignmentX(CENTER_ALIGNMENT);
        play.addActionListener(this);
        this.getRootPane().setDefaultButton(play);
        panelPlay.add(play);

        tokens = new JLabel(creditos.toString());
        panelPlay.add(tokens);

        this.add(panelPlay);

        win = new JLabel();
        win.setAlignmentX(CENTER_ALIGNMENT);
        win.setVisible(false);
        winPanel.add(win);

        this.add(winPanel);

        timerTitle.start();
    }

    Timer timerTitle = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Form.this.setTitle(titulo.substring(0, indice + 1));
            indice++;
            if (indice >= titulo.length()) {
                indice = 0;
            }
        }
    });

    Timer timerColors = new Timer(400, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            win.setForeground(new Color(r, g, b));
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon[] iconos = new ImageIcon[5];
        for (int i = 0; i < iconos.length; i++) {

            ImageIcon iconoOriginal = new ImageIcon("src/main/java/app/iconos/" + i + ".png");
            Image imagenOriginal = iconoOriginal.getImage();
            Image imagenRedimensionada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

            iconos[i] = new ImageIcon(imagenRedimensionada);
        }

        int[] randomNumbers = new int[3];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 5);
        }

        if (e.getSource() == play) {
            lbl1.setIcon(iconos[randomNumbers[0]]);
            lbl2.setIcon(iconos[randomNumbers[1]]);
            lbl3.setIcon(iconos[randomNumbers[2]]);

            creditos--;

            if (iconos[randomNumbers[0]] == iconos[randomNumbers[1]]
                    && iconos[randomNumbers[0]] == iconos[randomNumbers[2]]) {

                win.setText("Has ganado 5 Tokens");
                win.setVisible(true);
                creditos += 5;
                timerColors.start();
            } else if (iconos[randomNumbers[0]] == iconos[randomNumbers[1]]
                    && iconos[randomNumbers[0]] != iconos[randomNumbers[2]]
                    || iconos[randomNumbers[2]] == iconos[randomNumbers[1]]
                            && iconos[randomNumbers[2]] != iconos[randomNumbers[0]]) {
                win.setText("Has ganado 1,5 Tokens");
                win.setVisible(true);
                creditos += 1.5;
                timerColors.start();
            } else {
                win.setVisible(false);
                timerColors.stop();
            }

            if (creditos <= 0) {
                int opción = JOptionPane.showConfirmDialog(rootPane, "Has perdido, ¿Deseas volver a empezar?",
                        "Fin del juego", JOptionPane.OK_CANCEL_OPTION);

                tokens.setText("Sin tokens");

                if (opción == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                } else {
                    creditos = 10.0;
                }
            }

            tokens.setText(creditos.toString());
        }
    }

}
