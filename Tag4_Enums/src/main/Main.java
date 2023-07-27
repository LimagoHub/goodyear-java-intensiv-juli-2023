package main;

import de.goodyear.Monat;
import de.goodyear.Operation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Monat monat = Monat.FEBRUAR;

        double x =3;
        double y = 4;

        for(Operation op :Operation.values()) {
            System.out.println(op.calculate(x,y));
        }
        Arrays.stream(Operation.values()).forEach(o->System.out.println(o.calculate(x,y)));

        Arrays.stream(Monat.values()).filter(m->m.name().endsWith("R")).forEach(System.out::println);

        String string = "Februar";

        Monat feb = Monat.valueOf(string.toUpperCase());
        System.out.println(feb);
        int a = 1;
        feb = Monat.values()[1];

    }
}