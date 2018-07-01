package algo.sorting;

/**
 * Merge sort is a sorting technique based on divide and conquer technique. With worst-case time complexity
 * being Ο(n log n), it is one of the most respected algorithms.
 *
 * Merge sort first divides the array into equal halves and then combines them in a sorted manner.  The merge()
 * function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m]
 * and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 *
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = (l+r)/2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m+1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 */
public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length-1);
    }

    private void mergeSort(int[] array , int left, int right) {
        if (left < right) {
            // same as (left+right)/2, but avoids overflow  for large left and right
            int mid = (right+left)/2;

            // sort first half
            mergeSort(array, left, mid);
            // sort second half
            mergeSort(array, mid+1, right);

            // merge both the parts
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int i, j, k;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // create temp array
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp array
        for (i=0 ; i<n1 ; i++) {
            L[i] = array[left+i];
        }
        for (j=0 ; j<n2 ; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Merge the temp array back into the array[left ..... right]
        i = 0; // Initialize index for first subarray
        j = 0; // Initialize index for second subarray
        k = left; // Initialize index for merged subarray
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
                k++;
            } else {
                array[k] = R[j];
                j++;
                k++;
            }
        }

        // Copy remaining elements from L[], if there are any
        while (i<n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements from R[], if there are any
        while (j<n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
