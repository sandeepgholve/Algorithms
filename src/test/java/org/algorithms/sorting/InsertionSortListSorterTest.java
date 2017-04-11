package org.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by sgholve on 11/4/17.
 */
public class InsertionSortListSorterTest extends AbstractListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new InsertionSortListSorter(comparator);
    }
}
