package org.algorithms.recursion.backtracking;

/**
 * Generate / Print All N length strings from given string of length K where character can appear multiple times.
 *
 * <p>
 *     Example:
 *      String K = "ALGO"
 *      N = 2
 *
 *      Result:
 *      AA LA GA OA AL LL GL OL AG LG GG OG AO LO GO OO
 * </p>
 *
 * <p>
 *     Let T(n) be the running time of printAllNLengthStringsFromKLenght(n). Using Subtraction and Conquer Mater
 *     Theorem we get: T(n) = O(k^n)
 * </p>
 *
 *  Approach:
 *      1. Loop through i = 1 to K.
 *      2. Add k[i] to result array, which is the size N and make a recursive call to (N-1).
 *      3. Base Case: when n becomes 0 (means array is full)
 */
public class NLengthStringsFromKLength {
    public void printAllNLengthStringsFromKLenght(int n, char[] k, char[] A) {
        if (n <= 0) {
            System.out.print(String.valueOf(A) + " ");
        } else {
            for (int i = 0; i < k.length; i++) {
                A[n-1] = k[i];
                printAllNLengthStringsFromKLenght(n-1, k, A);
            }
        }
    }

    public static void main(String[] args) {
        String k = "ALGO";
        int n = 2;
        NLengthStringsFromKLength nLengthStringsFromKLength = new NLengthStringsFromKLength();
        nLengthStringsFromKLength.printAllNLengthStringsFromKLenght(n, k.toCharArray(), new char[n]);
    }
}
