package PriorityQueue.MinHeap;

public class PriorityQueue<T extends Comparable<T>> {

    /**
     * Custom MinHeap PriorityQueue class implemented
     * Author: Saad Ahmed
     * Date: 16 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private T[] heap;
    private int N;
    private int size;

    public PriorityQueue() {
        this.size = 0;
        this.N = 10;
        this.heap = (T[]) new Comparable[N];
    }

    private int parentIndex(int index) {
        if (index > 0) return (index - 1) / 2;
        return -1;
    }

    private boolean isLeaf(int index) {
        return index >= size / 2 && index < size;
    }

    private int leftChildIndex(int index) {
        if (!isLeaf(index)) return index * 2 + 1;
        return -1;
    }

    private int rightChildIndex(int index) {
        if (!isLeaf(index)) return index * 2 + 2;
        return -1;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void extend() {
        N *= 2;
        T[] oldHeap = heap;
        heap = (T[]) new Comparable[N];

        for (int i = 0; i < oldHeap.length; i++) {
            if (oldHeap[i] == null) break;
            heap[i] = oldHeap[i];
        }
    }

    /**
     * Time Complexity [offer()] function:
     * O(LogN)
     */

    public void offer(T data) {
        heap[size] = data;
        int tempIndex = size++;

        while (tempIndex > 0 && data.compareTo(heap[parentIndex(tempIndex)]) < 0) {
            swap(tempIndex, parentIndex(tempIndex));
            tempIndex = parentIndex(tempIndex);
        }

        if (size == N) extend();
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is empty");
        return heap[0];
    }

    /**
     * Time Complexity [poll()] function:
     * O(LogN)
     */

    public T poll() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is empty");

        T data = heap[0];
        heap[0] = heap[size-- - 1];
        int tempIndex = 0;

        while (tempIndex < size && !isLeaf(tempIndex)) {
            if (heap[tempIndex].compareTo(heap[leftChildIndex(tempIndex)]) > 0 || heap[tempIndex].compareTo(heap[rightChildIndex(tempIndex)]) > 0) {
                int swappingIndex;
                if (heap[leftChildIndex(tempIndex)].compareTo(heap[rightChildIndex(tempIndex)]) < 0) swappingIndex = leftChildIndex(tempIndex);
                else swappingIndex = rightChildIndex(tempIndex);

                swap(tempIndex, swappingIndex);
                tempIndex = swappingIndex;
            } else break;
        }

        return data;
    }

    /**
     * Time Complexity [size()] function:
     * O(1)
     */

    public int size() {
        return size;
    }

    /**
     * Time Complexity [isEmpty()] function:
     * O(1)
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Time Complexity [toString()] function:
     * O(N)
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        for (int i = 0; i < size - 1; i++) {
            sb.append(heap[i]);
            sb.append(',');
            sb.append(' ');
        }

        sb.append(heap[size - 1]);
        sb.append(']');

        return sb.toString();
    }
}