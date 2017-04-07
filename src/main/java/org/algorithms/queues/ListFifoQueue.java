package org.algorithms.queues;

import org.algorithms.lists.LinkedList;
import org.algorithms.lists.List;

/**
 * Created by sgholve on 7/4/17.
 */
public class ListFifoQueue implements Queue {

    private final List _list;

    public ListFifoQueue(List list) {
        assert list != null : "list can't be null";
        this._list = list;
    }

    public ListFifoQueue() {
        this(new LinkedList());
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        return _list.delete(0);
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
}
