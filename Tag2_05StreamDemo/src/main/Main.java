package main;

import de.tiere.Schwein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Main {
    public static void main(String[] args) {
    new Main().run();
    }

    private void run() {

        var liste = List.of(new Schwein("Eins"), new Schwein("Eins"), new Schwein("Drei"), new Schwein("Vier"), new Schwein("Eins"), new Schwein("Sechs"), new Schwein("Sieben"));

        var ergebnis =  liste
                .stream()
                .map(s->{s.fuettern(); return s;})

                .collect(groupingBy(Schwein::getName, summingInt(Schwein::getGewicht)));

        ergebnis.forEach((k,v)-> System.out.println(k + " = " + v));
    }

}