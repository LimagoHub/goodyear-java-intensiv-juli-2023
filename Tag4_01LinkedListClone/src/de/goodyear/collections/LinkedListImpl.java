package de.goodyear.collections;

import java.util.Optional;

public class LinkedListImpl<T> implements List<T>{


    private Kettenglied<T> start;
    private Kettenglied<T> actual;

    public LinkedListImpl() {
        start = actual = null;
    }

    @Override
    public void append(final T value) {
        Kettenglied<T> neu = new Kettenglied<>(value);
        if(isEmpty()) {
            start = neu;
        } else {
            moveToTail();
            actual.nach = neu;
            neu.vor = actual;
        }
        actual = neu;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public Optional<T> get() {
        return Optional.empty();
    }

    @Override
    public boolean update(final T newValue) {
        return false;
    }

    @Override
    public boolean moveToHead() {
        return false;
    }

    @Override
    public boolean moveToTail() {
        return false;
    }

    @Override
    public boolean movePrevious() {
        return false;
    }

    @Override
    public boolean moveNext() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public boolean isBeginOfList() {
        //return isEmpty() || actual.vor == null; // besser
        return actual == start; // nicht so gut
    }

    @Override
    public boolean isEndOfList() {

        return isEmpty() || actual.nach == null;
    }

    private class Kettenglied<T> {
       T payload;
       Kettenglied vor;
       Kettenglied nach;

        public Kettenglied(final T payload) {
            this.payload = payload;
            vor = nach = null;
        }
    }
}
