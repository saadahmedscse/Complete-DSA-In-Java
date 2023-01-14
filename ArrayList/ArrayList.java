package ArrayList;

public class ArrayList <T> {

    /**
     * Custom ArrayList class implemented
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private T[] array = (T[]) new Object[10];
    private int size = 0;

    /**
     * Time Complexity [extendSize()] function:
     * O(N)
     */

    private void extendSize() {
        T[] newArray = (T[]) new Object[size * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    /**
     * Time Complexity [add()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public void add(T data) {
        array[size++] = data;

        if (size == array.length) extendSize();
    }

    /**
     * Time Complexity [addFirst()] function:
     * O(N)
     */

    public void addFirst(T data) { // Time Complexity O (N)
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = data;
        size++;

        if (size == array.length) extendSize();
    }

    /**
     * Time Complexity [add(arg, arg)] function:
     * Best Case O(1)
     * Average Case O(N)
     * Worst Case O(N)
     */

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = data;
        size++;

        if (size == array.length) extendSize();
    }

    /**
     * Time Complexity [replace()] function:
     * O(1)
     */

    public void replace(int index, T data) {
        if (invalidIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);
        }

        array[index] = data;
    }

    /**
     * Time Complexity [remove()] function:
     * Best Case O(1)
     * Average Case O(N)
     * Worst Case O(N)
     */

    public void remove(int index) {
        if (invalidIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    /**
     * Time Complexity [removeItem()] function:
     * Best Case O(1)
     * Average Case O(N)
     * Worst Case O(N)
     */

    public void removeItem(T element) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }

        if (index == -1) System.out.println("Element not found");
        else remove(index);
    }

    /**
     * Time Complexity [get()] function:
     * O(1)
     */

    public T get(int index) {
        if (invalidIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Array index out of bound " + index);
        }

        return array[index];
    }

    /**
     * Time Complexity [indexOf()] function:
     * Best Case O(1)
     * Average Case O(N)
     * Worst Case O(N)
     */

    public int indexOf(T element) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= size;
    }

    /**
     * Time Complexity [add()] function:
     * O(N)
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]);
            sb.append(',');
            sb.append(' ');
        }

        sb.append(array[size - 1]);
        sb.append(']');

        return sb.toString();
    }

    /**
     * Time Complexity [size()] function:
     * O(1)
     */

    public int size() {
        return size;
    }
}
