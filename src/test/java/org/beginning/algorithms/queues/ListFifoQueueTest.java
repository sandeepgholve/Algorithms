package org.beginning.algorithms.queues;

/**
 * Created by sgholve on 7/4/17.
 */
public class ListFifoQueueTest extends AbstractFifoQueueTest {
    protected Queue createFifoQueue() {
        return new ListFifoQueue();
    }
}
