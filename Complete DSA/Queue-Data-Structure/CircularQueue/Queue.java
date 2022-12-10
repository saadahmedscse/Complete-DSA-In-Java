package CircularQueue;

public class Queue {
    int[] array;
    int front;
    int rear;
    int capacity;
    int size = 0;

    public Queue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        this.front = this.rear = -1;
    }

    public void enqueue(int data) { //Runtime Complexity O(1)
        if ((rear + 1) % capacity == front) throw new RuntimeException("Queue is full");

        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;

        size++;
        array[rear] = data;
    }

    public int dequeue() { //Runtime Complexity O(1)
        if (front == -1) throw new RuntimeException("Queue is empty");

        int result = array[front];

        if (front == rear) front = rear = -1;
        else front = (front + 1) % capacity;

        size--;
        return result;
    }

    public int peek() { //Runtime Complexity O(1)
        if (front == -1) throw new RuntimeException("Queue is empty");

        return array[front];
    }

    public int size() { //Runitme Complexity O(1)
        return size;
    }

    public boolean isEmpty() { //Runtime Complexity O(1)
        return front == -1 && rear == -1;
    }
}
