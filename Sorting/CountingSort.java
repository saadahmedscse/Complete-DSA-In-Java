package Sorting;

public class CountingSort {

    /**
     * Counting Sort Function
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

     /**
     * Complexity [sort()] function:
     * Time Complexity:     O(N + K)
     * Space Complexity:    O(N)
     */

    public static void sort(int[] array) {
        int n = array.length;
        int max = array[0];

        for (int i : array) if (i > max) max = i;

        int[] count = new int[max + 1];

        for (int i : array) count[i]++;

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            output[--count[array[i]]] = array[i];
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}