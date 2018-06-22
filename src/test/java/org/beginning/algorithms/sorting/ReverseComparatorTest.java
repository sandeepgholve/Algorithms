package org.beginning.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sgholve on 10/4/17.
 */
public class ReverseComparatorTest {
    @Test
    public void testLessThan() {
        assertTrue(ReverseComparator.INSTANCE.compare("B", "A") < 0);
    }

    @Test
    public void testGreaterThan() {
        assertTrue(ReverseComparator.INSTANCE.compare("A", "B") > 0);
    }

    @Test
    public void testEqualTo() {
        assertTrue(ReverseComparator.INSTANCE.compare("A", "A") == 0);
    }
}