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
        if(isEmpty()) return Optional.empty();
        return Optional.of(actual.payload);
    }

    @Override
    public boolean update(final T newValue) {

        if(isEmpty()) return false;
        actual.payload = newValue;
        return true;
    }



    @Override
    public boolean movePrevious() {
        if(isBeginOfList()) return false;
        actual = actual.vor;
        return true;
    }

    @Override
    public boolean moveNext() {
        if(isEndOfList()) return false;
        actual = actual.nach;
        return true;
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
