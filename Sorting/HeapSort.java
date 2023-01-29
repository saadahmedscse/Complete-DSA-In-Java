package Sorting;

public class HeapSort {

    /**
     * Heap Sort Function
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

     /**
     * Complexity [sort()] function:
     * Time Complexity:     O(NLogN)
     * Space Complexity:    O(LogN)
     */

    public static void sort(int[] array) {
        int n = array.length;
        buildHeap(array, n);

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
    }

    private static void buildHeap(int[] array, int n) {
        int startIndex = n / 2 + 1;

        if (startIndex > 0) {
            for (int i = startIndex; i >= 0; i--) {
                heapify(array, i, n);
            }
        }
    }

    private static void heapify(int[] array, int i, int n) {
        int largest = i;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        if (leftChild < n && array[leftChild] > array[largest]) largest = leftChild;
        if (rightChild < n && array[rightChild] > array[largest]) largest = rightChild;

        if (i != largest) {
            swap(array, i, largest);
            heapify(array, largest, n);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}