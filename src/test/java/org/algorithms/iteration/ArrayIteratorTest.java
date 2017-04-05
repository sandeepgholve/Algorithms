package org.algorithms.iteration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sgholve on 4/4/17.
 */
public class ArrayIteratorTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIterationRespectBounds() throws Exception {
        Object[] array = new Object[] {"A", "B", "C", "D", "E", "F"};

        ArrayIterator iterator = new ArrayIterator(array, 1, 3);

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[2], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[3], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail("Should not reach here.");
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }

}