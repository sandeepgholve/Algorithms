package org.algorithms.stacks;

import org.algorithms.lists.AbstractListTest;
import org.algorithms.lists.ArrayList;
import org.algorithms.lists.List;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sgholve on 8/4/17.
 */
public class UndoableListTest extends AbstractListTest {
    protected List createList() {
        return new UndoableList(new ArrayList());
    }

    @Test
    public void testUndoInsert() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.insert(0, VALUE_A);
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }

    @Test
    public void testUndoAdd() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }

    @Test
    public void testUndoDeleteByPosition() {
        UndoableList list = new UndoableList(new ArrayList(new Object[] {VALUE_A, VALUE_B}));

        assertFalse(list.canUndo());

        assertSame(VALUE_B, list.delete(1));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertFalse(list.canUndo());
    }

    @Test
    public void testUndoDeleteByValue() {
        UndoableList list = new UndoableList(new ArrayList(new Object[] {VALUE_A, VALUE_B}));

        assertFalse(list.canUndo());

        assertTrue(list.delete(VALUE_B));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertFalse(list.canUndo());
    }

    @Test
    public void testUndoSet() {
        UndoableList list = new UndoableList(new ArrayList(new Object[] {VALUE_A}));

        assertFalse(list.canUndo());

        assertSame(VALUE_A, list.set(0, VALUE_B));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertFalse(list.canUndo());
    }

    @Test
    public void testClearResetsUndoStack() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        assertTrue(list.canUndo());

        list.clear();
        assertFalse(list.canUndo());
    }

    @Test
    public void testUndoMultiple() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        list.add(VALUE_B);
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));

        assertTrue(list.canUndo());

        list.delete(0);

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }
}
