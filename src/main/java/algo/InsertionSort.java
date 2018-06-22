package algo;

public class InsertionSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        // iterate through i= 1 to n-1
        for (int i = 1; i < array.length; ++i) {
            int toBeSorted = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > toBeSorted) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = toBeSorted;
        }
    }
}
