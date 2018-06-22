package org.beginning.algorithms.lists;

import org.beginning.algorithms.iteration.Iterator;
import org.beginning.algorithms.iteration.IteratorOutOfBoundsException;

/**
 * Created by sgholve on 7/4/17.
 */
public class LinkedList implements List {

    private final Element _headAndTail = new Element(null);
    private int _size;

    public LinkedList() {
        clear();
    }

    public Iterator iterator() {
        return new ValueIterator();
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";

        if (index < 0 || index > _size)
            throw new IndexOutOfBoundsException();

        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }

    private Element getElement(int index) {
        Element element = _headAndTail.getNext();

        for (int i = index; i > 0; i--) {
            element = element.getNext();
        }
        return element;
    }

    public void add(Object value) {
        insert(_size, value);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
        element.detach();
        --_size;
        return element.getValue();
    }

    public boolean delete(Object value) {
        assert value != null : "value can't be null";

        for (Element e = _headAndTail.getNext(); e != _headAndTail; e = e.getNext()) {
            if (value.equals(e.getValue())) {
                e.detach();
                --_size;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        _headAndTail.setPrevious(_headAndTail);
        _headAndTail.setNext(_headAndTail);
        _size = 0;
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        checkOutOfBounds(index);

        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);

        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    private void checkOutOfBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= _size;
    }

    public int indexOf(Object value) {
        assert value != null : "value can't be null";

        int index = 0;

        for (Element e = _headAndTail.getNext(); e != _headAndTail; e = e.getNext()) {
            if (value.equals(e.getValue()))
                return index;

            index++;
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
        return size() == 0;
    }

    /**
     * Inner Element class for storing node information
     */
    public static final class Element {
        private Object _value;
        private Element _previous;
        private Element _next;

        public Element(Object value) {
            this._value = value;
        }

        public Object getValue() {
            return _value;
        }

        public void setValue(Object value) {
            assert value != null : "value can't be null";
            this._value = value;
        }

        public Element getPrevious() {
            return _previous;
        }

        public void setPrevious(Element previous) {
            assert previous != null : "previous can't be null";
            this._previous = previous;
        }

        public Element getNext() {
            return _next;
        }

        public void setNext(Element next) {
            assert next != null : "next can't be null";
            this._next = next;
        }

        public void attachBefore(Element next) {
            assert next != null : "next can't be null";

            Element previous = next.getPrevious();

            setNext(next);
            setPrevious(previous);

            next.setPrevious(this);
            previous.setNext(this);
        }

        public void detach() {
            _previous.setNext(_next);
            _next.setPrevious(_previous);
        }
    }

    private final class ValueIterator implements Iterator {
        private Element _current = _headAndTail;

        public void first() {
            _current = _headAndTail.getNext();
        }

        public void last() {
            _current = _headAndTail.getPrevious();
        }

        public boolean isDone() {
            return _current == _headAndTail;
        }

        public void next() {
            _current = _current.getNext();
        }

        public void previous() {
            _current = _current.getPrevious();
        }

        public Object current() throws IteratorOutOfBoundsException {
            if (isDone())
                throw new IteratorOutOfBoundsException();
            return _current.getValue();
        }
    }
}
