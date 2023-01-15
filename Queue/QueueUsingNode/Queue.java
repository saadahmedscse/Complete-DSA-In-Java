package Queue.QueueUsingNode;

public class Queue<T> {

    /**
     * Custom Queue class implemented using Node
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private Node<T> front;
    private Node<T> rear;
    private int size = 0;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Time Complexity [offer()] function:
     * O(1)
     */

    public void offer(T data) {
        Node<T> newNode = new Node<>(data);

        size++;

        if (front == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (size() == 0) throw new RuntimeException("Queue is empty");

        return front.data;
    }

    /**
     * Time Complexity [poll()] function:
     * O(1)
     */

    public T poll() {
        if (size() == 0) throw new RuntimeException("Queue is empty");

        T data = front.data;

        front = front.next;
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
        if (size() == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<T> currentNode = front;

        while (currentNode.next != null) {
            sb.append(currentNode.data);
            sb.append(',');
            sb.append(' ');
            currentNode = currentNode.next;
        }

        sb.append(currentNode.data);
        sb.append(']');

        return sb.toString();
    }
}