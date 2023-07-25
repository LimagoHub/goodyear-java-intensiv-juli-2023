package de.office;

import java.io.Serializable;

public class Word extends WordPad implements Dokument, Serializable {

    @Override
    public void drucken() {
        System.out.println("Hier druckt Word");
    }
}
