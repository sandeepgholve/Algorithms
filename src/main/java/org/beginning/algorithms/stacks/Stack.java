package org.beginning.algorithms.stacks;

import org.beginning.algorithms.queues.Queue;

/**
 * Created by sgholve on 7/4/17.
 */
public interface Stack extends Queue {
    public void push(Object value);
    public Object pop() throws EmptyStackException;
    public Object peek() throws EmptyStackException;
    public void clear();
    public int size();
    public boolean isEmpty();
}
