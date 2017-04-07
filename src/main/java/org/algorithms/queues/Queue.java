package org.algorithms.queues;

/**
 * Created by sgholve on 7/4/17.
 */
public interface Queue {
    public void enqueue(Object value);
    public Object dequeue() throws EmptyQueueException;
    public void clear();
    public int size();
    public boolean isEmpty();
}
