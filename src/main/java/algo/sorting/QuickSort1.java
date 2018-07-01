package algo.sorting;

public class QuickSort1 {
    private int[] input;
    private int length;

    public void sort(int[] array) {
        if (array == null || array.length <= 1)
            return;
        this.input = array;
        this.length = array.length;
        quickSort(0, length-1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = input[low + (high-low)/2];

        /**
         * In each iteration, we will identify a number from left side which is greater than pivot value, and a number
         * from right side which is less then pivot value. Once search is complete, we swap both the numbers.
         */
        if (i <= j) {
            while(input[i] < pivot) {
                i++;
            }
            while(input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main (String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

        System.out.println("Array before sorting = " + array);
        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.sort(array);
        System.out.println("Array after sorting = " + array);
    }
}
