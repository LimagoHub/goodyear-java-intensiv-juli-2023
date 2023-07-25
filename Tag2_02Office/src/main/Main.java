package main;

import de.office.Dokument;
import de.office.Excel;
import de.office.Word;

public class Main {
    public static void main(String[] args) {

        Dokument dokument = new Excel();
        dokument.drucken();
    }
}