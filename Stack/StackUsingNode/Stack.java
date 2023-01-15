package Stack.StackUsingNode;

public class Stack <T> {

    /**
     * Custom Stack class implemented usign Node
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private Node<T> head;
    private int size = 0;

    private class Node <T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Time Complexity [push()] function:
     * O(1)
     */

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (size() == 0) throw new StackOverflowError("Stack is empty");
        return head.data;
    }

    /**
     * Time Complexity [pop()] function:
     * O(1)
     */

    public T pop() {
        if (size() == 0) throw new StackOverflowError("Stack is empty");
        T data = head.data;
        head = head.next;
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

        Node<T> currentNode = head;

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