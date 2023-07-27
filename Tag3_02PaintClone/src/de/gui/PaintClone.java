package de.gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.text.Format;

public class PaintClone extends Frame {


    public enum Form {
        LINE,
        RECTANGLE,
        OVAL,
        CLEAR;
    }

    private final static int SIZE = 1000;

    private BufferedImage image = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    private Form form = Form.LINE;
    private Color color = Color.WHITE;


    public PaintClone() {
        super("PaintClone");
        setSize(SIZE,SIZE);
        setResizable(false);
        setBackground(Color.BLACK);
        addWindowListener(new MyWindowListerener());
        addMouseListener(new MyMouseListener());
        setMenuBar(new MyMenuBar(this));
    }

    public Form getForm() {
        return form;
    }

    public void setForm(final Form form) {
        this.form = form;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public void close() {
        dispose();
    }

    public void save() {
        var chooser = createFileChooser();
        var selection = chooser.showSaveDialog(this);
        if(selection == JFileChooser.APPROVE_OPTION) {
            System.out.println("auswahl");
        }

    }

    public void load() {
        var chooser = createFileChooser();
        var selection = chooser.showOpenDialog(this);
    }



    @Override
    public void paint(final Graphics g) {
        g.drawImage(image,0,0,this);
    }

    public void drawForm(final Point start, final Point end) {
        Rectangle rectangle = createNormalizedRectangleFromCoordinates(start, end);
        renderForm(rectangle);
    }

    private void renderForm(final Rectangle rectangle) {
        Graphics graphics = image.getGraphics();
        graphics.setColor(getColor());
        switch (getForm()) {
            case LINE-> graphics.drawLine(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height);
            case OVAL -> graphics.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            case RECTANGLE -> graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            case CLEAR -> graphics.clearRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        graphics.dispose();
        repaint();
    }

    private JFileChooser createFileChooser() {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Bitte Grafikdatei waehlen:");
        chooser.addChoosableFileFilter(new FileTypeFilter("png", "Portable Network Graphic" ));
        chooser.addChoosableFileFilter(new FileTypeFilter("gif", "Graphics Interchange Format" ));
        chooser.addChoosableFileFilter(new FileTypeFilter("jpg", "JPEG" ));



        return chooser;
    }
    private Rectangle createNormalizedRectangleFromCoordinates(final Point start, final Point end) {

        var rectangle = new Rectangle();
        rectangle.x = start.x<end.x ? start.x : end.x;
        rectangle.y = start.y < end.y ?  start.y : end.y;
        rectangle.width = Math.abs(end.x - start.x);
        rectangle.height = Math.abs(end.y - start.y);
        return rectangle;

    }

    public static void main(String[] args) {
        new PaintClone().setVisible(true);
    }
    private class MyMouseListener extends MouseAdapter {

        private final Point startPoint = new Point();

        @Override
        public void mousePressed(final MouseEvent e) {
            startPoint.move(e.getX(),e.getY());
        }

        @Override
        public void mouseReleased(final MouseEvent e) {
             drawForm(startPoint, new Point(e.getX(),e.getY()));
        }


    }

    private class MyWindowListerener extends WindowAdapter {
        @Override
        public void windowClosing(final WindowEvent e) {
            close();
        }
    }

    private class FileTypeFilter extends FileFilter {
        private String extension;
        private String description;

        public FileTypeFilter(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            return file.getName().endsWith(extension);
        }

        public String getDescription() {
            return description + String.format(" (*%s)", extension);
        }
    }
}