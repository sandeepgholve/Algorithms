package org.algorithms.lists;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sgholve on 5/4/17.
 */
public class ArrayListTest extends AbstractListTest {
    protected List createList() {
        return new ArrayList();
    }

    @Test
    public void testResizeBeyondInitialCapacity() {
        List list = new ArrayList();
        list.add(VALUE_A);
        list.add(VALUE_A);
        list.add(VALUE_A);
        assertEquals(3, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.get(1));
        assertSame(VALUE_A, list.get(2));
    }

    @Test
    public void testDeleteFromLastElementInArray() {
        List list = new ArrayList();
        list.add(new Object());
        list.delete(0);
    }
}
