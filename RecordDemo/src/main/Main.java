package main;

import records.DataEvent;
import records.Person;

public class Main {
    public static void main(String[] args) {

        Person p = new Person("John", "Doe");

        System.out.println(p.vorname());
        System.out.println(p.toString());


        DataEvent<String> event = new DataEvent<>("Hallo");
        System.out.println(event);
    }
}