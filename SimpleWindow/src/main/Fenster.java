package main;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame{

    private static final int SIZE = 500;

    private String message = "Hallo Fenster";

    private int x;
    private int y;


    public Fenster()  {
        super("Ein tolles Fenster");
        addKeyListener(new MyKeyListener());
        addMouseMotionListener(new MyMouseMotionListerner());
        setSize(SIZE, SIZE);
        x = y = SIZE / 2;
    }

    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.RED);
        g.drawString(message, 100,100);
        g.fillRect(x,y, 30, 30);
    }

    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }

    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(final KeyEvent e) {
            message = "Taste wurde gedrueckt";
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                dispose();

            repaint();
        }

    }

    class MyMouseMotionListerner extends MouseMotionAdapter {
        @Override
        public void mouseMoved(final MouseEvent e) {
            x += (e.getX()-x)/100;
            y += (e.getY()-y)/100;
            repaint();
        }
    }
}