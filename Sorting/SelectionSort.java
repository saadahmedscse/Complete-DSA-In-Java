package Sorting;

public class SelectionSort {

    /**
     * Selection Sort Function
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
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (array[min] > array[j]) min = j;
            }

            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}