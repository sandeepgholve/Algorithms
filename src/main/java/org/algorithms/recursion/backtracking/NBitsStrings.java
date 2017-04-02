package org.algorithms.recursion.backtracking;

import java.util.Arrays;

/**
 * Generate all strings of n bits, consider A[0 .. n-1] is an array of size n. Its an example of Backtracking
 * algorithms using Recursion.
 *
 * <p>
 *     For given N = 3
 *
 *     Output:
 *     [0, 0, 0]
 *     [1, 0, 0]
 *     [0, 1, 0]
 *     [1, 1, 0]
 *     [0, 0, 1]
 *     [1, 0, 1]
 *     [0, 1, 1]
 *     [1, 1, 1]
 * </p>
 */
public class NBitsStrings {
    int[] arrayA;

    public NBitsStrings(int n) {
        arrayA = new int[n];
    }

    public void nBits(int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arrayA));
        } else {
            arrayA[n-1] = 0;
            nBits(n-1);
            arrayA[n-1] = 1;
            nBits(n-1);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 3;
        NBitsStrings nBitsStrings = new NBitsStrings(n);
        nBitsStrings.nBits(n);
    }
}
