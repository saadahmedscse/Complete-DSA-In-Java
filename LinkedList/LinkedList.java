package LinkedList;

public class LinkedList <T> {

    /**
     * Custom LinkedList class implemented
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node <T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Time Complexity [add()] function:
     * O(1)
     */

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }

    /**
     * Time Complexity [addFirst()] function:
     * O(1)
     */

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    /**
     * Time Complexity [insert()] function:
     * Best Case O(1)
     * Average Case O(N)
     * Worst Case O(N)
     */

    public void insert(int index, T data) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);

        if (index == size) {
            add(data);
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> currentNode = head;

        while (index-- > 1) currentNode = currentNode.next;

        Node<T> newNode = new Node<>(data);
        Node<T> next = currentNode.next;
        currentNode.next = newNode;
        newNode.prev = currentNode;
        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    /**
     * Time Complexity [replace()] function:
     * O(N)
     */

    public void replace(int index, T data) {
        if (invalidIndex(index)) throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);

        if (index == 0) {
            head.data = data;
            return;
        }

        Node<T> currentNode = head;

        while (index-- > 0) currentNode = currentNode.next;
        currentNode.data = data;
    }

    /**
     * Time Complexity [removeFirst()] function:
     * O(1)
     */

    public void removeFirst() {
        if (headIsNull()) throw new ArrayIndexOutOfBoundsException("List is empty");
        head = head.next;
        if (head != null) head.prev = null;
        size--;
    }

    /**
     * Time Complexity [removeLast()] function:
     * O(1)
     */

    public void removeLast() {
        if (headIsNull()) throw new ArrayIndexOutOfBoundsException("List is empty");

        if (size == 1) {
            size--;
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;

        size--;
    }

    /**
     * Time Complexity [remove()] function:
     * O(N)
     */

    public void remove(int index) {
        if (headIsNull()) throw new ArrayIndexOutOfBoundsException("List is empty");
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<T> currentNode = head;

        while (index-- > 1) currentNode = currentNode.next;

        currentNode.next = currentNode.next.next;
        currentNode.next.prev = currentNode;
        size--;
    }

    /**
     * Time Complexity [get()] function:
     * O(N)
     */

    public T get(int index) {
        if (invalidIndex(index)) throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);

        Node<T> currentNode = head;

        while (index-- > 0) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Time Complexity [indexOf()] function:
     * O(N)
     */

    public int indexOf(T data) {
        int index = -1;

        Node<T> currentNode = head;

        while (currentNode != null) {
            index++;
            if (data.equals(currentNode.data)) return index;
            currentNode = currentNode.next;
        }

        return -1;
    }

    private boolean headIsNull() {
        return head == null;
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= size;
    }

    /**
     * Time Complexity [size()] function:
     * O(1)
     */

    public int size() {
        return size;
    }

    /**
     * Time Complexity [toString()] function:
     * O(N)
     */

    public String toString() {
        if (headIsNull()) return "[]";
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