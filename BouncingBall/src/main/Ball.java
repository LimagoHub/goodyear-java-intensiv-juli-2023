package main;

import java.awt.*;

public class Ball extends Item {

    private Rectangle rectangle;

    public Ball(final Point location) {
        super(location);
        rectangle = new Rectangle(location.x,location.y, 30,30);
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void draw(final Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(location.x, location.y, rectangle.width, rectangle.height);
    }
}
