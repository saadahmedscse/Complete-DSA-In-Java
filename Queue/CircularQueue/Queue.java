package Queue.CircularQueue;

public class Queue <T> {

    /**
     * Custom Queue class implemented using Circular Array
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private T[] array;
    private int front = -1;
    private int rear = -1;
    private int capacity;
    private int size = 0;

    public Queue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Time Complexity [offer()] function:
     * O(1)
     */

    public void offer(T data) {
        if ((rear + 1) % capacity == front) throw new RuntimeException("Queue is full");

        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;

        array[rear] = data;
        size++;
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (front == -1) throw new RuntimeException("Queue is empty");

        return array[front];
    }

    /**
     * Time Complexity [poll()] function:
     * O(1)
     */

    public T poll() {
        if (front == -1) throw new RuntimeException("Queue is empty");

        T data = array[front];

        if (front == rear) front = rear = -1;
        else front = (front + 1) % capacity;

        size--;
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

        int i = front;
        int tempSize = size;

        while (tempSize-- > 1) {
            sb.append(array[i]);
            sb.append(',');
            sb.append(' ');

            i = (i + 1) % capacity;
        }

        sb.append(array[i]);
        sb.append(']');

        return sb.toString();
    }
}