package QueueUsingLinkedList;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println(q.dequeue());

        System.out.println(q.size());

        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }
    }
}
