package main;

import de.tiere.Schwein;

import java.util.*;

public class Main {
    public static void main(String[] args) {



//      List<Tier> tiere = new ArrayList<>();
//      tiere.add(new Tier());
//      tiere.add(new Katze());
//      tiere.add(new Hund());
//      tiere.add(new Pudel());
//
//
//
//      List<Hund> hunde = new ArrayList<Hund>();
//      hunde.add(new Hund());
//      hunde.add(new Pudel());
//
//        List demo = hunde;
//        //List<Object> d2 = hunde;
//        demo.add(new Katze());
//
////      List<Tier> t2;
////      t2 = new ArrayList<Hund>(); //Nix gehen
////        t2.add(new Katze());
//
//      List<Katze> katzen = new ArrayList<>();
//      katzen.add(new Katze());
//
//      List<Object> objects = new ArrayList<>();
//      objects.add(new Main());
//
//      ausgabe(tiere);
//      ausgabe(hunde);
//      ausgabe(katzen);
//
//      fillWithAnimals(tiere);
//        fillWithAnimals(objects);
//        String s ="";
//        //add(s);
//
//        add(new Hund());

        Map<String, Integer> planeten = new HashMap<>();
        planeten.put("Merkur", 1000);
        planeten.put("Venus", 2000);
        planeten.put("Erde", 3000);
        planeten.put("Merkur", 1500);

        Set<String> keys = planeten.keySet();
        for(String planet : keys) {
            System.out.printf("Planet %s hat den Durchmesser %s%n", planet, planeten.get(planet));
        }

    }
    public static void ausgabe(List<? extends Tier> liste) {

        for(Tier tier: liste) {
            System.out.println(tier);
        }
    }

    public static void fillWithAnimals(List<? super Tier> dinge) {
        dinge.add(new Hund());
        dinge.add(new Katze());
        dinge.add(new Pudel());
        dinge.add(new Tier());

        for(Object o: dinge) {
            System.out.println(o);
        }
    }

    public static <T extends Tier> T add(T a){
        System.out.println(a.getClass().getSimpleName());
        return a;
    }
}



class Tier {}

class Katze extends Tier {}

class Hund extends Tier {}

class Pudel extends Hund {}