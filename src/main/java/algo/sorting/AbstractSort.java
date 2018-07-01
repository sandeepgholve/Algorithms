package algo.sorting;

public abstract class AbstractSort {
    final void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    final void swap(int[] array, int x, int y) {
        if (x != y) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

    public abstract void sort(int[] array);
}
