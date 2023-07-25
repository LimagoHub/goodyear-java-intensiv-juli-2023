package de.tiere;



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
        //System.out.println("Hallo");
    }

    // Instanzkonstruktor
    public Schwein() {
        this("Nobody");
    }

    public Schwein(String name) {
        setName(name);
        setGewicht(10);
        erhoeheAnzahl();

    }



    public String getName() {
        return name;
    }

    public final void setName(final String name) {
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
