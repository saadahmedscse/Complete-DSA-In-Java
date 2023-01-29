package Sorting;

public class BubbleSort {
    /**
     * Bubble Sort Function
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

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}