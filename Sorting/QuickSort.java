package Sorting;

public class QuickSort {

    /**
     * Quick Sort Function
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

     /**
     * Complexity [sort()] function:
     * Time Complexity:     O(NLogN)
     * Space Complexity:    O(1)
     */

    public static void sort(int[] array) {
        int n = array.length;

        quickSort(array, 0, n - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(array, low, mid);

        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < high && array[i] <= pivot) i++;
            while (j >= 0 && array[j] > pivot) j--;

            if (i < j) swap(array, i, j);
        }

        swap(array, low, j);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}