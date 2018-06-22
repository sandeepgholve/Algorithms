package algo;

public abstract class AbstractSort {
    final void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public abstract void sort(int[] array);

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 10, 12, 1, 5, 6};

        AbstractSort sorter = new BubbleSort();
        sorter.sort(array);

        sorter.printArray(array);
    }

}
