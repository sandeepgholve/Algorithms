package org.beginning.algorithms.sorting;

import org.beginning.algorithms.lists.ArrayList;
import org.beginning.algorithms.lists.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sgholve on 11/4/17.
 */
public class ListSorterCallCountingTest {
    private static final int TEST_SIZE = 100;

    private final List _sortedArrayList = new ArrayList(TEST_SIZE);
    private final List _reversedArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    @Before
    public void setUp() throws Exception {
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);

        for (int i = 1; i <= TEST_SIZE; ++i) {
            _sortedArrayList.add(new Integer(i));
        }

        for (int i = TEST_SIZE; i > 0 ; --i) {
            _reversedArrayList.add(new Integer(i));
        }

        for (int i = 1; i <= TEST_SIZE; ++i) {
            _randomArrayList.add(new Integer((int)(TEST_SIZE * Math.random())));
        }
    }

    @Test
    public void testWorstCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls("testWorstCaseBubbleSort", _comparator.getCallCount());
    }

    @Test
    public void testWorstCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls("testWorstCaseSelectionSort", _comparator.getCallCount());
    }

    @Test
    public void testWorstCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_reversedArrayList);
        reportCalls("testWorstCaseInsertionSort", _comparator.getCallCount());
    }

    @Test
    public void testBestCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls("testBestCaseBubbleSort", _comparator.getCallCount());
    }

    @Test
    public void testBestCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls("testBestCaseSelectionSort", _comparator.getCallCount());
    }

    @Test
    public void testBestCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls("testBestCaseInsertionSort", _comparator.getCallCount());
    }

    @Test
    public void testAverageCaseBubbleSort() {
        new BubbleSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls("testAverageCaseBubbleSort", _comparator.getCallCount());
    }

    @Test
    public void testAverageCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls("testAverageCaseSelectionSort", _comparator.getCallCount());
    }

    @Test
    public void testAverageCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls("testAverageCaseInsertionSort", _comparator.getCallCount());
    }

    private void reportCalls(String methodName, int callCount) {
        System.out.println(methodName + ": " + callCount + " calls.");
    }
}
