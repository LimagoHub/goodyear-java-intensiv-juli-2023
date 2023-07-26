package de.goodyear.collections;


import java.io.Serializable;
import java.util.Stack;

/**
 * Eine tolle Klasse
 */
public class Stapel<HERBERT> {

    private static final int DEFAULT_SIZE = 10;

    private HERBERT [] data;
    private int index;
    public Stapel() throws StapelException  {
        this(DEFAULT_SIZE);
    }
    public Stapel(int size) throws StapelException {
       try {
            data = (HERBERT[]) new Object[size];
            index = 0;
        } catch (RuntimeException e) {
            throw new StapelException("Upps",e);
        }
    }


    /**
     *
     * @param value
     */
    public void push(HERBERT value) throws StapelException { // Verhalten im Fehlerfall
        if(isFull()) throw new StapelException("Overflow");
        data[index ++] = value;
    }

    /**
     *
     * @return
     */
    public HERBERT pop() throws StapelException {
        if(isEmpty()) throw new StapelException("Underflow");
        return data[--index];
    }

    public boolean isFull() {
        return index >= data.length;
    }

    public boolean isEmpty() {
        return index <= 0;
    }
}
