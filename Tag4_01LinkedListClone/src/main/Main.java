package main;

import de.client.ListClient;
import de.goodyear.collections.LinkedListImpl;
import de.goodyear.collections.List;
import de.tiere.Schwein;

public class Main {
    public static void main(String[] args) {


        List<Schwein> schweineListe = new LinkedListImpl<>();
        ListClient client = new ListClient(schweineListe);
        client.start();
    }
}