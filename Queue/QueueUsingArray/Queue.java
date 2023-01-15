package Queue.QueueUsingArray;

public class Queue <T> {

    /**
     * Custom Queue class implemented using Array
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private T[] array;
    private int rear = 0;

    public Queue (int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Time Complexity [offer()] function:
     * O(1)
     */

    public void offer(T data) {
        if (rear == array.length) throw new ArrayIndexOutOfBoundsException("Queue Overflow");

        array[rear++] = data;
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (size() == 0) throw new ArrayIndexOutOfBoundsException("Queue is empty");

        return array[0];
    }

    /**
     * Time Complexity [poll()] function:
     * O(N)
     */

    public T poll() {
        if (size() == 0) throw new ArrayIndexOutOfBoundsException("Queue is empty");

        T data = array[0];

        for (int i = 0; i < rear - 1; i++) {
            array[i] = array[i + 1];
        }
        rear--;

        return data;
    }

    /**
     * Time Complexity [size()] function:
     * O(1)
     */

    public int size() {
        return rear;
    }

    /**
     * Time Complexity [isEmpty()] function:
     * O(1)
     */

    public boolean isEmpty() {
        return rear == 0;
    }

    /**
     * Time Complexity [toString()] function:
     * O(N)
     */

    public String toString() {
        if (size() == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < rear - 1; i++) {
            sb.append(array[i]);
            sb.append(',');
            sb.append(' ');
        }

        sb.append(array[rear - 1]);
        sb.append(']');

        return sb.toString();
    }
}