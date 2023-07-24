package main;

import de.tiere.Schwein;

public class Main {
    public static void main(String[] args) throws Exception{

        new Main().run();
    }

    private void run() throws Exception {
        System.out.println(Schwein.getAnzahl());

        // Deklaration Zur Kompilierung
        Schwein piggy;


        piggy = new Schwein(); // Zur Laufzeit
        System.out.println(Schwein.getAnzahl());

        System.out.println(piggy);



        piggy.fuettern();

        System.out.println(piggy);

        piggy = null;
        System.gc();

        Thread.sleep(1000);
        System.out.println(Schwein.getAnzahl());
    }
}