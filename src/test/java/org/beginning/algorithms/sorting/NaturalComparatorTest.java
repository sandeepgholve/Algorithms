package org.beginning.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sgholve on 10/4/17.
 */
public class NaturalComparatorTest {
    @Test
    public void testLessThan() {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "B") < 0);
    }

    @Test
    public void testGreaterThan() {
        assertTrue(NaturalComparator.INSTANCE.compare("B", "A") > 0);
    }

    @Test
    public void testEqualTo() {
        assertTrue(NaturalComparator.INSTANCE.compare("A", "A") == 0);
    }
}