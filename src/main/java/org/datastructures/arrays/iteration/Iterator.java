package org.datastructures.arrays.iteration;

/**
 * Created by sgholve on 4/4/17.
 */
public interface Iterator {
    void first();
    void last();
    boolean isDone();
    void next();
    void previous();
    Object current() throws IteratorOutOfBoundException;
}
