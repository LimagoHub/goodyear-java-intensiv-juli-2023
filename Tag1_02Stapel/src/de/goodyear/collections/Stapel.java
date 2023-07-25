package de.goodyear.collections;


import java.io.Serializable;

/**
 * Eine tolle Klasse
 */
public class Stapel<HERBERT> {

    private static final int DEFAULT_SIZE = 10;

    private HERBERT [] data;
    private int index;
    public Stapel() {
        this(DEFAULT_SIZE);
    }
    public Stapel(int size) {
        data = (HERBERT[]) new Object[size<0?DEFAULT_SIZE:size];
        index = 0;
    }


    /**
     *
     * @param value
     */
    public void push(HERBERT value) { // Verhalten im Fehlerfall
        if(isFull()) return;
        data[index ++] = value;
    }

    /**
     *
     * @return
     */
    public HERBERT pop() {
        if(isEmpty()) return null;
        return data[--index];
    }

    public boolean isFull() {
        return index >= data.length;
    }

    public boolean isEmpty() {
        return index <= 0;
    }
}
