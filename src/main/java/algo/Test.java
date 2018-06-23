package algo;

public class Test {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 10, 12, 1, 5, 6};

        AbstractSort sorter = new MergeSort();
        sorter.sort(array);

        sorter.printArray(array);
    }

}
