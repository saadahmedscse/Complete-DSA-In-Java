package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {

    /**
     * Custom HashMap class implemented
     * Author: Saad Ahmed
     * Date: 14 Jan, 2023
     * Tried to implement most common functions of the in build class
     */

    private int size;
    private int N;
    private LinkedList<Node>[] bucket;

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        this.N = 4;
        bucket = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    private int getHash(K key) {
        int bucketIndex = key.hashCode();
        return Math.abs(bucketIndex) % N;
    }

    private int searchInList(K key, int bucketIndex) {
        for (int i = 0; i < bucket[bucketIndex].size(); i++) {
            if (bucket[bucketIndex].get(i).key.equals(key)) return i;
        }

        return -1;
    }

    private void reHash() {
        size = 0;
        N *= 2;
        LinkedList<Node>[] oldBucket = bucket;
        bucket = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            bucket[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> currentList = oldBucket[i];

            for (int j = 0; j < currentList.size(); j++) {
                Node currentNode = currentList.get(j);
                put(currentNode.key, currentNode.value);
            }
        }
    }

    /**
     * Time Complexity [put()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public void put(K key, V value) {
        int bucketIndex = getHash(key);
        int valueIndex = searchInList(key, bucketIndex);

        if (valueIndex >= 0) {
            Node node = bucket[bucketIndex].get(valueIndex);
            node.value = value;
            return;
        }

        bucket[bucketIndex].add(new Node(key, value));
        size++;

        double lambda = (double) size / N;

        if (lambda > 8.0) reHash();
    }

    /**
     * Time Complexity [get()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public V get(K key) {
        int bucketIndex = getHash(key);
        int valueIndex = searchInList(key, bucketIndex);

        if (valueIndex >= 0) {
            return bucket[bucketIndex].get(valueIndex).value;
        }

        return null;
    }

    /**
     * Time Complexity [remove()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public V remove(K key) {
        int bucketIndex = getHash(key);
        int valueIndex = searchInList(key, bucketIndex);

        if (valueIndex >= 0) {
            V data = bucket[bucketIndex].get(valueIndex).value;
            bucket[bucketIndex].remove(valueIndex);
            size--;

            return data;
        }

        return null;
    }

    /**
     * Time Complexity [containsKey()] function:
     * Best Case O(1)
     * Average Case O(1)
     * Worst Case O(N)
     */

    public boolean containsKey(K key) {
        int bucketIndex = getHash(key);
        int valueIndex = searchInList(key, bucketIndex);

        if (valueIndex >= 0) return true;
        return false;
    }

    /**
     * Time Complexity [containsValue()] function:
     * O(N)
     */

    public boolean containsValue(V value) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                if (bucket[i].get(j).value.equals(value)) return true;
            }
        }

        return false;
    }

    /**
     * Time Complexity [keySet()] function:
     * O(N)
     */

    public ArrayList<K> keySet() {
        ArrayList<K> keyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                keyList.add(bucket[i].get(j).key);
            }
        }

        return keyList;
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
}