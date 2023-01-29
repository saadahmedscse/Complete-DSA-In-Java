package Sorting;

public class MergeSort {
    /**
     * Merge Sort Function
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

        mergeSort(array, 0, n - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (array[i] < array[j]) temp[k] = array[i++];
            else temp[k] = array[j++];
            k++;
        }

        while (i <= mid) temp[k++] = array[i++]; // For rest of the elements
        while (j <= end) temp[k++] = array[j++]; // For rest of the elements

        k = 0;

        for (int x = start; x <= end; x++) {
            array[x] = temp[k++];
        }
    }
}