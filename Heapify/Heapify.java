package Heapify;

public class Heapify {

    /**
     * Max Heapify and Heap Sort Implemented
     * Author: Saad Ahmed
     * Date: 17 Jan, 2023
     */


    /**
     * Time Complexity [buildHeap()] function:
     * O(NLogN)
     */

    public static void buildHeap(int[] array) {
        int N = array.length;

        int startIndex = N / 2 - 1; // First non-leaf node

        if (startIndex >= 0) {
            for (int i = startIndex; i >= 0; i--) {
                heapify(array, i, N);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Time Complexity [heapify()] function:
     * O(LogN)
     */

    private static void heapify(int[] array, int i, int N) {
        int largest = i;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        if (leftChild < N && array[leftChild] > array[largest]) largest = leftChild;
        if (rightChild < N && array[rightChild] > array[largest]) largest = rightChild;

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, N);
        }
    }

    /**
     * Time Complexity [heapSort()] function:
     * O(NLogN)
     */

    public static void heapSort(int[] array) {
        int N = array.length;

        for (int i = N - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
    }
}