package de.gui;

import java.awt.*;

public class PaintClone extends Frame {


    private final static int SIZE = 1000;

    public PaintClone() {
        super("PaintClone");
        setSize(SIZE,SIZE);
        setMenuBar(new MyMenuBar());
    }

    public static void main(String[] args) {
        new PaintClone().setVisible(true);
    }
}