package QueueUsingArray;

public class Queue {
    int[] array;
    int rear = -1;
    int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void enqueue(int data) { //Runtime complexity O(1)
        if (rear == capacity) throw new RuntimeException("Queue is full");

        array[++rear] = data;
    }

    public int dequeue() { //Runtime complexity O(n)
        if (rear == -1) throw new RuntimeException("Queue is empty");

        int data = array[0];

        for (int i = 0; i < rear; i++) {
            array[i] = array[i + 1];
        }

        rear--;

        return data;
    }

    public int peek() { //Runtime complexity O(1)
        if (rear == -1) throw new RuntimeException("Queue is empty");

        return array[0];
    }

    public int size() { //Runtime complexity O(1)
        return rear + 1;
    }

    public boolean isEmpty() { //Runtime complexity O(1)
        return rear == -1;
    }
}
