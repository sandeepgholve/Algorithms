package algo.sorting;

public class Test {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 10, 12, 1, 5, 6};

        AbstractSort sorter = new QuickSort();
        sorter.sort(array);

        sorter.printArray(array);
    }

}
