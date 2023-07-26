package de.gui;

import java.awt.*;

public class MyMenuBar extends MenuBar {

    public MyMenuBar()  {

        Menu menu;
        MenuItem menuItem;

        menu = new Menu("Datei");
        menuItem = new MenuItem("Speichern");
        menu.add(menuItem);
        menuItem = new MenuItem("Laden");
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new MenuItem("Beenden");
        menu.add(menuItem);
        add(menu);

        menu = new Menu("Farben");
        add(menu);

    }
}
