package org.beginning.algorithms.sorting;

import org.beginning.algorithms.lists.List;

import java.util.Comparator;

/**
 * Created by sgholve on 11/4/17.
 */
public class SelectionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    public SelectionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        this._comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "list can't be null";

        int size = list.size();

        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check) {
                if (_comparator.compare(list.get(smallest), list.get(check)) > 0) {
                    smallest = check;
                }
            }
            swap(list, smallest, slot);
        }
        return list;
    }

    private void swap(List list, int left, int right) {
        if (left == right)
            return;
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
