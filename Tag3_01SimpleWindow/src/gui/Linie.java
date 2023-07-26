package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Linie extends Frame {


    private static final int SIZE = 600;

    private BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);

    public Linie() throws HeadlessException {
        setSize(SIZE,SIZE);
        setResizable(false);
        addMouseListener(new MyMouseListener());
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(final Graphics g) {
       g.drawImage(image,0,0, this); // Schattenfenster in Screen kopieren
    }

    public static void main(String[] args) {
        new Linie().setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {

        private int x;
        private int y;
        @Override
        public void mousePressed(final MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseReleased(final MouseEvent e) {
            Graphics schattenfenster = null;
            try {
                schattenfenster = image.getGraphics();
                //schattenfenster.setColor(Color.RED);
                schattenfenster.drawLine(x, y, e.getX(), e.getY());
            } finally {
                schattenfenster.dispose();
            }

            repaint();
        }
    }
}