package main;

import java.awt.*;

public class Fenster extends Frame{

    private int counter = 0;

    public Fenster()  {
        super("Ein tolles Fenster");
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Hallo Fenster. Counter = " + counter++, 100,100);
    }

    public static void main(String[] args) {
        new Fenster();
    }
}