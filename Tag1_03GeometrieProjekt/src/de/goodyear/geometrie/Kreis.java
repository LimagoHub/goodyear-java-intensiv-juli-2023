package de.goodyear.geometrie;

public class Kreis extends Punkt{

    private double radius;

//    public Kreis() {
//        super(2,2); // In Methodenschreibweise darf super nur in einem Ctor verwendet werden und muss an der ersten Stelle stehen
//        setRadius(0);
//    }


    public Kreis() {
        this(0,0,0);// This ist Konstruktorweiterleitung (ruft anderen Ctor in der selben Klasse)
    }
    public Kreis(final double radius) {
        this(radius,0,0);
    }

    public Kreis(final double x, final double y) {
        this(0,x,y);
    }

    public Kreis(final double radius, final double x, final double y) {
        super(x,y);
        setRadius(radius);
     }


    public double getRadius() {
        return radius;
    }

    public final void setRadius(final double radius) {
        if(radius < 0) return;
        this.radius = radius; // Referenzschreibweise Reflexsivzeiger (zeigt auf sich selbst)
    }

    @Override
    public String toString() {
        return super.toString() + ",Radius = " + getRadius();
    }
}
