package de.tiere;

import main.DefaultCleaner;

public class Schwein {


    // Instanzvariablen
    private String name;
    private int gewicht;

    // Klassenvariable
    private static int anzahl;

    public static int getAnzahl() {
       return anzahl;
    }

    private static void erhoeheAnzahl() {
        anzahl++;
    }

    private static void vermindereAnzahl() {
        anzahl--;
    }

    // Klassenkonstruktor (KAI)
    static {
        anzahl = 0;
    }


    // Anonymer Konstruktor
    {
        System.out.println("Hallo");
    }

    // Instanzkonstruktor
    public Schwein() {
        name = "Nobody";
        gewicht = 10;
        erhoeheAnzahl();
        DefaultCleaner.INSTANCE.register(this, ()->Schwein.vermindereAnzahl());
    }



    public String getName() {
        return name;
    }

    public void setName(final String name) {
        if("Elsa".equals(name)) throw new IllegalArgumentException("Schwein darf nicht Elsa heissen");

        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(final int gewicht) {
        this.gewicht = gewicht;
    }

    public void fuettern() {
        setGewicht(getGewicht() + 1);
        // gewicht ++
    }


    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }


}
