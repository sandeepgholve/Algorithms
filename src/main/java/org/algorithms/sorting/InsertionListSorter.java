package org.algorithms.sorting;

import org.algorithms.iteration.Iterator;
import org.algorithms.lists.LinkedList;
import org.algorithms.lists.List;

import java.util.Comparator;

/**
 * Created by sgholve on 11/4/17.
 */
public class InsertionListSorter implements ListSorter {
    private final Comparator _comparator;

    public InsertionListSorter(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        this._comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "list can't be null";

        final List result = new LinkedList();

        Iterator iterator = list.iterator();

        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            int slot = result.size();
            while (slot > 0) {
                if (_comparator.compare(iterator.current(), result.get(slot - 1)) >= 0) {
                    break;
                }
                --slot;
            }
            result.insert(slot, iterator.current());
        }
        return result;
    }
}
