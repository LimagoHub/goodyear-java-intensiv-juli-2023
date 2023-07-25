package main;

import de.goodyear.collections.Stapel;
import de.goodyear.geometrie.Kreis;
import de.goodyear.geometrie.Punkt;
import de.tiere.Schwein;

public class Main {
    public static void main(String[] args) {

        Stapel<Punkt> stapel = new Stapel<>(40);

        for (int i = 0; i < 10; i++) {

                stapel.push(new Punkt(i,i));
                stapel.push(new Kreis(i));
                //stapel.push(new Schwein("Schwein Nr. " + i));
                //stapel.push(i); // Auto-Boxing

        }

        while( !stapel.isEmpty()) {
            Punkt  p= stapel.pop();

            p.rechts();
            System.out.println(p);
        }
    }
}