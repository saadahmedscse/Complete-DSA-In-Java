public class Queue {

    private Node front;
    private Node rear;
    private int size = 0;

    private class Node {
        Node next;
        int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public void enqueue(int data) {
        size++;
        Node node = new Node(data);

        if (front == null) {
            front = rear = node;
            return;
        }

        rear.next = node;
        rear = node;
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");

        int data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public int peek() {
        if (front == null) throw new RuntimeException("Queue is empty");

        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

