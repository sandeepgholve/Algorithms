package org.beginning.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by sgholve on 10/4/17.
 */
public class ReverseComparator implements Comparator {
    public static final ReverseComparator INSTANCE = new ReverseComparator();

    private ReverseComparator() {
    }

    public int compare(Object left, Object right) {
        assert right != null : "right object can't be null";
        return ((Comparable) right).compareTo(left);
    }
}
