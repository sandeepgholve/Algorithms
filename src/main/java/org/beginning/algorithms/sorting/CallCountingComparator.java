package org.beginning.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by sgholve on 11/4/17.
 */
public class CallCountingComparator implements Comparator {
    private final Comparator _comparator;
    private int _count;

    public CallCountingComparator(Comparator comparator) {
        assert comparator != null : "comparator can't bee null";
        this._comparator = comparator;
        this._count = 0;
    }

    public int compare(Object left, Object right) {
        ++_count;
        return _comparator.compare(left, right);
    }

    public int getCallCount() {
        return _count;
    }
}
