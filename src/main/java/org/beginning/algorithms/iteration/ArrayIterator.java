package org.beginning.algorithms.iteration;

/**
 * Created by sgholve on 4/4/17.
 */
public class ArrayIterator implements Iterator {

    private final Object[] _array;
    private final int _first;
    private final int _last;
    private int _current;

    /**
     * ArrayIterator constructor which allow you give access to part/portion of the array.
     * @param array Array to be iterated
     * @param start Starting position of the (part of the) array.
     * @param length Length of the (part of the) array.
     */
    public ArrayIterator(Object[] array, int start, int length) {
        assert array != null : "array can't be null";
        assert start >= 0 : "start can't be < 0";
        assert start < array.length : "start can't be > array.length";
        assert length >= 0 : "length can't be < 0";

        _array = array;
        _first = start;
        _last = start + length - 1;

        assert _last < array.length : "start + length can't > array.length";
    }

    /**
     * ArrayIterator constructor to iterate array.
     * @param array Array to be iterated on.
     */
    public ArrayIterator(Object[] array) {
        assert array != null : "array can't be null";

        _array = array;
        _first = 0;
        _last = array.length - 1;
    }

    public void first() {
        _current = _first;
    }

    public void last() {
        _current = _last;
    }

    public boolean isDone() {
        return _current < _first || _current > _last;
    }

    public void next() {
        _current++;
    }

    public void previous() {
        _current--;
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone())
            throw new IteratorOutOfBoundsException();

        return _array[_current];
    }
}
