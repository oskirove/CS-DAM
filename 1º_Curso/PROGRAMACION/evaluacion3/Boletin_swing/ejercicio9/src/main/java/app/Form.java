package app;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Form extends JFrame implements ActionListener {

    private JButton btnLeft;
    private JButton btnRight;
    private ArrayList<JLabel> bombas = new ArrayList<>();
    private JLabel abel;
    private boolean colision;
    private int intervalo = 200;

    public Form() {
        super("Rúa do Príncipe");
        ImageIcon iconoFondo = new ImageIcon("src/main/java/app/public/bg.png");
        Image imagenFondo = iconoFondo.getImage();
        BgImg BgImg = new BgImg(imagenFondo);
        BgImg.setLayout(null);
        this.setContentPane(BgImg);

        ImageIcon iconoAbel = new ImageIcon("src/main/java/app/public/abel.png");
        Image imagenAbel = iconoAbel.getImage();
        Image imgAbelFinal = imagenAbel.getScaledInstance(70, 145, Image.SCALE_SMOOTH);

        abel = new JLabel();
        abel.setIcon(new ImageIcon(imgAbelFinal));
        abel.setBounds(360, 170, 70, 140);
        this.add(abel);

        btnLeft = new JButton("<");
        btnLeft.setBounds(330, 420, 60, 30);
        btnLeft.addActionListener(this);
        this.add(btnLeft);

        btnRight = new JButton(">");
        btnRight.setBounds(400, 420, 60, 30);
        btnRight.addActionListener(this);
        this.add(btnRight);

        for (int i = 0; i < 3; i++) {
            crearBomba();
        }

        timer.start();
        timerBombas.start();
        timerInrtervalo.start();
    }

    private void crearBomba() {
        ImageIcon iconoBomba = new ImageIcon("src/main/java/app/public/bomb.png");
        Image imagenBomba = iconoBomba.getImage();
        Image imgBombaFinal = imagenBomba.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        JLabel bomba = new JLabel(new ImageIcon(imgBombaFinal));
        int randomX = (int) (Math.random() * 700) + 50;
        bomba.setBounds(randomX, 0, 50, 50);
        bombas.add(bomba);
        this.add(bomba);
    }

    Timer timerBombas = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            crearBomba();
        }
    });

    Timer timerInrtervalo = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (intervalo > 20) {
                intervalo -= 1;
            }
        }
    });

    Timer timer = new Timer(intervalo, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (JLabel bomba : new ArrayList<>(bombas)) {
                bomba.setBounds(bomba.getX(), bomba.getY() + 7, bomba.getWidth(), bomba.getHeight());
                if (bomba.getBounds().intersects(abel.getBounds())) {
                    ImageIcon iconoExplosion = new ImageIcon("src/main/java/app/public/explosion.png");
                    Image imagenExplosion = iconoExplosion.getImage();
                    Image imgExplosionFinal = imagenExplosion.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

                    bomba.setIcon(new ImageIcon(imgExplosionFinal));
                    colision = true;
                }

                if (colision) {
                    timer.stop();
                    int option = JOptionPane.showOptionDialog(Form.this, "Has perdido ¿Deseas jugar de nuevo?",
                            "Fin de la partida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            null,
                            null);

                    if (option == JOptionPane.OK_OPTION) {
                        abel.setBounds(360, 170, 70, 140);
                        for (JLabel b : bombas) {
                            Form.this.remove(b);
                        }
                        for (JLabel b : new ArrayList<>(bombas)) {
                            Form.this.remove(b);
                        }

                        bombas.clear();
                        Form.this.revalidate();
                        Form.this.repaint();

                        for (JLabel b : bombas) {
                            int randomX = (int) (Math.random() * 700) + 50;
                            b.setIcon(new ImageIcon(new ImageIcon("src/main/java/app/public/bomb.png").getImage()
                                    .getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
                            b.setBounds(randomX, 0, 50, 50);
                        }

                        colision = false;
                        timer.start();
                        timerBombas.start();

                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLeft) {
            ImageIcon iconoAbelLeft = new ImageIcon("src/main/java/app/public/abelLeft.png");
            Image imagenAbelLeft = iconoAbelLeft.getImage();
            Image imgAbelFinalLeft = imagenAbelLeft.getScaledInstance(70, 145, Image.SCALE_SMOOTH);

            abel.setIcon(new ImageIcon(imgAbelFinalLeft));
            abel.setBounds(abel.getX() - 16, abel.getY(), abel.getWidth(), abel.getHeight());

            if (abel.getX() < 0) {
                abel.setBounds(0, abel.getY(), abel.getWidth(), abel.getHeight());
            }

        } else if (e.getSource() == btnRight) {
            ImageIcon iconoAbel = new ImageIcon("src/main/java/app/public/abel.png");
            Image imagenAbel = iconoAbel.getImage();
            Image imgAbelFinal = imagenAbel.getScaledInstance(70, 145, Image.SCALE_SMOOTH);

            abel.setIcon(new ImageIcon(imgAbelFinal));
            abel.setBounds(abel.getX() + 16, abel.getY(), abel.getWidth(), abel.getHeight());

            if (abel.getX() > 730) {
                abel.setBounds(730, abel.getY(), abel.getWidth(), abel.getHeight());
            }
        }
    }
}