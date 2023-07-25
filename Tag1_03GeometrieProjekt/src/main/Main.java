package main;

import de.goodyear.geometrie.Kreis;
import de.goodyear.geometrie.Punkt;

public class Main {
    public static void main(String[] args) {

        Object o;
        Punkt p;

        Kreis k;

        k = new Kreis();

        p = k;

        o = k;

        System.out.println(k.toString());
        System.out.println(p.toString());
        System.out.println(o.toString());

    }
}