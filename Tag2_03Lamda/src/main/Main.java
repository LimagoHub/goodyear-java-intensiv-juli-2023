package main;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Demo demo = new Demo();

        BiFunction<Double, Double, Double> f = demo::add;

        System.out.println(f.apply(3.0,4.0));

        f = demo::sub;

        System.out.println(f.apply(3.0,4.0));

        f = (a,b)->a * b;

        System.out.println(f.apply(3.0,4.0));
    }
}
class Demo {

    public double add(double a ,double b) {
        return a + b;
    }

    public double sub(double a ,double b) {
        return a - b;
    }
}


