package algo;

public class BubbleSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        int cout = 0;
        boolean swapped = true;
        final int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            if (swapped) {
                swapped = false;
                for (int j = 0; j < length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                        cout++;
                    }
                }
            }
        }
        System.out.println("Count = " + cout);
    }
}
