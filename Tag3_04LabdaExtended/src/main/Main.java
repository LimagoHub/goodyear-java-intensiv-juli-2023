package main;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    int a = 10;
    public static void main(String[] args) {

        new Main().run();
    }

    private void run() {
        Consumer<Integer> consumer = foo();
        consumer.accept(20);

        var liste = List.of("Eins","Zwei", "Drei","Vier");

        //liste.forEach(System.out::println);
        liste.forEach(s-> System.out.println(s.length()));
    }

    private Consumer<Integer> foo() {
        final int y = 10;

        Consumer<Integer> consumer = x-> System.out.println(x + y);



        return consumer;
    }
}