package de.client;

import de.goodyear.collections.List;
import de.tiere.Schwein;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ListClient {
    private enum Command {Ende, Append,Get,Update,Remove,MoveFirst,MoveLast,MovePrevious,MoveNext, Status};
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final List<Schwein> liste;

    public ListClient(final List<Schwein> liste) {
        this.liste = liste;
    }



    private Schwein createSchwein() {
        try {
            System.out.print("Bitte geben Sie dem Schwein einen Namen: ");
            String name = in.readLine();
            return new Schwein(name);
        } catch (IOException e) {
            return new Schwein("Zombieschwein");
        }
    }

    public void start() {


        do {
            switch (showMenu()) {
                case Append -> liste.append(createSchwein());
                case Get -> System.out.println(liste.get());
                case Update-> liste.update(createSchwein());
                case Remove-> liste.remove();
                case MoveFirst->liste.moveToTail();
                case MoveLast->liste.moveToTail();
                case MovePrevious->liste.movePrevious();
                case MoveNext->liste.moveNext();
                case Status->System.out.println("Empty=" + liste.isEmpty() + ", Bof=" + liste.isBeginOfList() + ", Eof=" + liste.isEndOfList());
                case Ende -> {return;}

            }

        } while (true);
    }

    private Command showMenu() {
        do {
            try {


                for (int i = 0 ; i < Command.values().length; i ++ ) {
                    System.out.println(i + "................" + Command.values()[i]);
                }

                return Command.values()[Integer.valueOf(in.readLine())];
            } catch (Throwable e) {
                System.err.println("Unbekannter Befehl");

            }
        } while (true);
    }
}
