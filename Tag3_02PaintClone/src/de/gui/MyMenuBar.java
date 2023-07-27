package de.gui;


import java.util.LinkedHashMap;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

import static de.gui.PaintClone.Form.*;
public class MyMenuBar extends MenuBar {

    private final PaintClone paintClone;
    private Menu currentMenu;

    public MyMenuBar(final PaintClone paintClone)  {

        this.paintClone = paintClone;
        createMenuBar();

    }

    private void createMenuBar() {
        createMenuStructureMap().forEach(this::createMenu);
    }

    private void createMenu(final String label, final Map<String, ActionListener> itemMap) {
        currentMenu = new Menu(label);
        itemMap.forEach(this::createMenuItem);
        add(currentMenu);
    }

    private void createMenuItem(final String label, final ActionListener actionListener){
        var menuItem = new MenuItem(label);
        menuItem.addActionListener(actionListener);
        currentMenu.add(menuItem);
    }

    private Map<String, Map<String, ActionListener>> createMenuStructureMap() {
//        return Map.ofEntries(
//                entry("Datei", Map.ofEntries(
//                        entry("Speichern", e->paintClone.save()),
//                        entry("Laden", e->paintClone.load()),
//                        entry("Beenden", e->paintClone.close())
//                ))
//                ,
//                entry("Formen", Map.ofEntries(
//                        entry("Linie", e->paintClone.setForm(LINE)),
//                        entry("Oval", e->paintClone.setForm(OVAL)),
//                        entry("Rechteck", e->paintClone.setForm(RECTANGLE)),
//                        entry("Loeschen", e->paintClone.setForm(CLEAR))
//
//                ))
//                ,
//                entry("Farben", Map.ofEntries(
//                        entry("Weiss", e->paintClone.setColor(Color.WHITE)),
//                        entry("Rot", e->paintClone.setColor(Color.RED)),
//                        entry("Gruen", e->paintClone.setColor(Color.GREEN)),
//                        entry("Blau", e->paintClone.setColor(Color.BLUE)),
//                        entry("Gelb", e->paintClone.setColor(Color.YELLOW)),
//                        entry("Schwarz", e->paintClone.setColor(Color.BLACK)),
//                        entry("Pink", e->paintClone.setColor(Color.PINK))
//
//                ))
//        );




        final var result = new LinkedHashMap<String, Map<String, ActionListener>>();
        result.put("Datei", createDateiItems());
        result.put("Formen", createFormenItems());
        result.put("Farben", createFarbenItems());
        return result;
    }


    private Map<String, ActionListener> createDateiItems() {
        final var dateiItems = new LinkedHashMap<String, ActionListener>();
        dateiItems.put("Speichern", e->paintClone.save());
        dateiItems.put("Laden", e->paintClone.load());
        dateiItems.put("Beenden", e->paintClone.close());
        return dateiItems;
    }
    private Map<String, ActionListener> createFormenItems() {
        final var formenItems = new LinkedHashMap<String, ActionListener>();
        formenItems.put("Linie",    e->setForm(LINE));
        formenItems.put("Oval",     e->setForm(OVAL));
        formenItems.put("Rechteck", e->setForm(RECTANGLE));
        formenItems.put("Loeschen", e->setForm(CLEAR));
        return formenItems;
    }

    private Map<String, ActionListener> createFarbenItems() {
        final var farbenItems = new LinkedHashMap<String, ActionListener>();
        farbenItems.put("Weiss",    e->setColor(Color.WHITE));
        farbenItems.put("Rot",      e->setColor(Color.RED));
        farbenItems.put("Gruen",    e->setColor(Color.GREEN));
        farbenItems.put("Blau",     e->setColor(Color.BLUE));
        farbenItems.put("Gelb",     e->setColor(Color.YELLOW));
        farbenItems.put("Schwarz",  e->setColor(Color.BLACK));
        farbenItems.put("Pink",     e->setColor(Color.PINK));
        return farbenItems;
    }

    private void setColor(final Color color) {
        paintClone.setColor(color);
    }
    private void setForm( PaintClone.Form form) {
        paintClone.setForm(form);
    }


}
