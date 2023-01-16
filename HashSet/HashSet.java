package HashSet;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashSet<T> {

    /**
     * Custom HashSet class implemented
     * Author: Saad Ahmed
     * Date: 16 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private int size;
    private int N;
    private LinkedList<Node>[] bucket;

    private class Node {
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public HashSet() {
        this.size = 0;
        this.N = 4;
        this.bucket = new LinkedList[N];

        for (int i = 0; i < N; i++) bucket[i] = new LinkedList<>();
    }

    private int getBucketIndex(T data) {
        int bucketIndex = data.hashCode();
        return Math.abs(bucketIndex) % N;
    }

    private int getValueIndex(T data, int bucketIndex) {
        LinkedList<Node> node = bucket[bucketIndex];

        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).data.equals(data)) return i;
        }

        return -1;
    }

    public void reHash() {
        size = 0;
        N *= 2;
        LinkedList<Node>[] oldBucket = bucket;
        bucket = new LinkedList[N];

        for (int i = 0; i < N; i++) bucket[i] = new LinkedList<>();

        for (LinkedList<Node> currentList : oldBucket) {
            for (Node currentNode : currentList) {
                add(currentNode.data);
            }
        }
    }

    /**
     * Time Complexity [add()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public boolean add(T data) {
        int bucketIndex = getBucketIndex(data);
        int valueIndex = getValueIndex(data, bucketIndex);

        if (valueIndex == -1) {
            bucket[bucketIndex].add(new Node(data));
            size++;

            double lambda = (double) size / N;
            if (lambda > 8.0) reHash();

            return true;
        }

        return false;
    }

    /**
     * Time Complexity [contains()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public boolean contains(T data) {
        int bucketIndex = getBucketIndex(data);
        int valueIndex = getValueIndex(data, bucketIndex);

        return valueIndex >= 0;
    }

    /**
     * Time Complexity [remove()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public boolean remove(T data) {
        int bucketIndex = getBucketIndex(data);
        int valueIndex = getValueIndex(data, bucketIndex);

        if (valueIndex >= 0) {
            bucket[bucketIndex].remove(valueIndex);
            size--;
            return true;
        }

        return false;
    }

    /**
     * Time Complexity [getSet()] function:
     * O(N)
     */

    public ArrayList<T> getSet() {
        ArrayList<T> list = new ArrayList<>();

        for (LinkedList<Node> currentList : bucket) {
            for (Node currentNode : currentList) {
                list.add(currentNode.data);
            }
        }

        return list;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}