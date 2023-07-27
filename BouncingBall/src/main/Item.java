package main;

import java.awt.*;

public abstract class Item {

    protected Point location;


    public Item(final Point location) {
        this.location = location;

    }

    public Point getLocation() {
        return location;
    }

    public abstract Rectangle getRectangle();

    public abstract void draw(Graphics g);
}
