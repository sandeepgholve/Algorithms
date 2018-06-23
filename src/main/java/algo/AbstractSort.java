package algo;

public abstract class AbstractSort {
    final void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public abstract void sort(int[] array);
}
