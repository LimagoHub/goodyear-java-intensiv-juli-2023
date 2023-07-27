package de.goodyear.collections;

import java.util.Optional;

public interface List<T> {

    void append(T value);
    boolean remove();
    Optional<T> get();
    boolean update(T newValue);

    default void clear() {
        while (remove());
    }

    default boolean moveToHead() {
        if (isEmpty()) return false;
        while (movePrevious());
        return true;
    }

    default boolean moveToTail() {
        if (isEmpty()) return false;
        while(moveNext());
        return true;
    }

    boolean movePrevious();

    boolean moveNext();

    boolean isEmpty();

    /*
        liefert true wenn die Liste leer ist oder Cursor auf der ersten Stelle steht
     */
    boolean isBeginOfList();

    /*
       liefert true wenn die Liste leer ist oder Cursor auf der letzten Stelle steht
    */
    boolean isEndOfList();

}
