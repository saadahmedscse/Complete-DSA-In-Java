package Sorting;

public class InsertionSort {

    /**
     * Insertion Sort Function
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

     /**
     * Complexity [sort()] function:
     * Time Complexity:     O(N^2)
     * Space Complexity:    O(1)
     */

    public static void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j--];
            }

            array[j + 1] = temp;
        }
    }
}