package org.algorithms.lists;

import org.algorithms.iteration.ArrayIterator;
import org.algorithms.iteration.Iterator;

/**
 * Created by sgholve on 5/4/17.
 */
public class ArrayList implements List {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private final int _initialCapacity;
    private Object[] _array;
    private int _size;

    public ArrayList() {
        this._initialCapacity = DEFAULT_INITIAL_CAPACITY;
    }

    public ArrayList(int initialCapacity) {
        assert initialCapacity > 0 : "initialCapacity must be > 0.";

        this._initialCapacity = initialCapacity;
        clear();
    }

    public Iterator iterator() {
        return new ArrayIterator(_array, 0, _size);
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";

        if (index < 0 || index > _size)
            throw new IndexOutOfBoundsException();

        ensureCapacity(_size + 1);
    }

    private void ensureCapacity(int capacity) {
        assert capacity > 0 : "Capacity must be > 0";

        if (_array.length < capacity) {
            Object[] copy = new Object[capacity + capacity / 2];
            System.arraycopy(_array, 0, copy, 0, _size);
            _array = copy;
        }
    }

    public void add(Object value) {
        insert(_size, value);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBound(index);
        Object value = _array[index];
        int copyFromIndex = index + 1;

        if (copyFromIndex < _size) {
            System.arraycopy(_array, copyFromIndex, _array, index, _size - copyFromIndex);
        }
        _array[--_size] = null;
        return value;
    }

    public boolean delete(Object value) {
        int index = indexOf(value);
        if (index != -1) {
            delete(index);
            return true;
        }
        return false;
    }

    public void clear() {
        _array = new Object[_initialCapacity];
        _size = 0;
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        checkOutOfBound(index);
        Object oldValue = _array[index];
        _array[index] = value;
        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBound(index);
        return _array[index];
    }

    private void checkOutOfBound(int index) {
        if (isOutOfBound(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isOutOfBound(int index) {
        return index < 0 || index >= _size;
    }

    public int indexOf(Object value) {
        assert value != null : "value can't be null";

        for (int i = 0 ; i < _size ; i++) {
            if (value.equals(_array[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }
}
