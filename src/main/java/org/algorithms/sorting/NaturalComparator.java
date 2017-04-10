package org.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by sgholve on 10/4/17.
 */
public class NaturalComparator implements Comparator {
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    private NaturalComparator() {
    }

    public int compare(Object left, Object right) {
        assert left != null : "left object can't be null";
        return ((Comparable) left).compareTo(right);
    }
}
