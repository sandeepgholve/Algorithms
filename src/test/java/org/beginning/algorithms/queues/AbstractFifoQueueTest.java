package org.beginning.algorithms.queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sgholve on 7/4/17.
 */
public abstract class AbstractFifoQueueTest {

    private static final String VALUE_A = "A";
    private static final String VALUE_B = "B";
    private static final String VALUE_C = "C";

    private Queue _queue;

    @Before
    public void setUp() throws Exception {
        _queue = createFifoQueue();
    }

    protected abstract Queue createFifoQueue();

    @Test
    public void testAccessAnEmptyQueue() {
        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // Expected.
        }
    }

    @Test
    public void testEnqueueDequeue() {
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_C);

        assertEquals(3, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_A, _queue.dequeue());
        assertEquals(2, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_B, _queue.dequeue());
        assertEquals(1, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_C, _queue.dequeue());
        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // Expected.
        }
    }

    @Test
    public void testClear() {
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_C);

        assertEquals(3, _queue.size());
        assertFalse(_queue.isEmpty());

        _queue.clear();

        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // Expected.
        }
    }
}