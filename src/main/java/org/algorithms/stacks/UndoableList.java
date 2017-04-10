package org.algorithms.stacks;

import org.algorithms.iteration.Iterator;
import org.algorithms.lists.ArrayList;
import org.algorithms.lists.List;

/**
 * Created by sgholve on 8/4/17.
 */
public class UndoableList implements List {
    private final Stack _undoStack = new ListStack();
    private final List _list;

    public UndoableList(ArrayList list) {
        assert list != null : "list can't be null";
        _list = list;
    }

    public Iterator iterator() {
        return _list.iterator();
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        _list.insert(index, value);
        _undoStack.push(new UndoInsertAction(index));
    }

    public void add(Object value) {
        insert(size(), value);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        Object value = _list.delete(index);
        _undoStack.push(new UndoDeleteAction(index, value));
        return value;
    }

    public boolean delete(Object value) {
        int index = indexOf(value);
        if (index == -1)
            return false;

        delete(index);
        return true;
    }

    public void clear() {
        _list.clear();
        _undoStack.clear();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        Object originalValue = _list.set(index, value);
        _undoStack.push(new UndoSetAction(index, originalValue));
        return originalValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        return _list.get(index);
    }

    public int indexOf(Object value) {
        return _list.indexOf(value);
    }

    public boolean contains(Object value) {
        return _list.contains(value);
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public boolean canUndo() {
        return !_undoStack.isEmpty();
    }

    public void undo() {
        ((UndoAction) _undoStack.pop()).execute();
    }

    private static interface UndoAction {
        public void execute();
    }

    private final class UndoInsertAction implements UndoAction {
        private final int _index;

        public UndoInsertAction(int index) {
            _index = index;
        }

        public void execute() {
            _list.delete(_index);
        }
    }

    private final class UndoDeleteAction implements UndoAction {
        private final int _index;
        private final Object _value;

        public UndoDeleteAction(int index, Object value) {
            this._index = index;
            this._value = value;
        }

        public void execute() {
            _list.insert(_index, _value);
        }
    }

    private final class UndoSetAction implements UndoAction {
        private final int _index;
        private final Object _value;

        public UndoSetAction(int index, Object value) {
            this._index = index;
            this._value = value;
        }

        public void execute() {
            _list.set(_index, _value);
        }
    }
}
