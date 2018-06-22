package org.beginning.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by sgholve on 11/4/17.
 */
public class BubbleSortListSorterTest extends AbstractListSorterTest {
    protected ListSorter createListSorter(Comparator comparator) {
        return new BubbleSortListSorter(comparator);
    }
}
