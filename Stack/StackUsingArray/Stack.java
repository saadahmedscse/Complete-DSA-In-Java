package Stack.StackUsingArray;

public class Stack <T> {

    /**
     * Custom Stack class implemented
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private T[] array;
    private int top = 0;

    public Stack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Time Complexity [push()] function:
     * O(1)
     */

    public void push(T data) {
        if (isFull()) throw new StackOverflowError("Stack Overflow!");

        array[top++] = data;
    }

    /**
     * Time Complexity [pop()] function:
     * O(1)
     */

    public T pop() {
        if (size() == 0) throw new StackOverflowError("Stack is empty");
        return array[top-- -1];
    }

    /**
     * Time Complexity [peek()] function:
     * O(1)
     */

    public T peek() {
        if (size() == 0) throw new StackOverflowError("Stack is empty");
        return array[top - 1];
    }

    /**
     * Time Complexity [isFull()] function:
     * O(1)
     */

    private boolean isFull() {
        return top == array.length;
    }

    /**
     * Time Complexity [size()] function:
     * O(1)
     */

    public int size() {
        return top;
    }

    /**
     * Time Complexity [isEmpty()] function:
     * O(1)
     */

    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Time Complexity [toString()] function:
     * O(N)
     */

    public String toString() {
        if (size() == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = top - 1; i > 0; i--) {
            sb.append(array[i]);
            sb.append(',');
            sb.append(' ');
        }

        sb.append(array[0]);
        sb.append(']');

        return sb.toString();
    }
}
