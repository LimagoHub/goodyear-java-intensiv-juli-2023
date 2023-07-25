package de.office;

public class Excel implements Dokument{
    @Override
    public void drucken() {
        System.out.println("Hier druckt Excel");
    }
}
