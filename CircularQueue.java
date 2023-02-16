public class CircularQueue {
    private static int[] arr;
    private static int front, rear;
    private static int capacity = 0;

    CircularQueue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
        capacity = size;
    }

    boolean isFull() {
        if (front == 0 && rear == capacity - 1)
            return true;
        else if (front == rear + 1)
            return true;
        else
            return false;
    }

    void enqueue(int value) {
        if (!isFull()) {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % capacity;
            arr[rear] = value;
        } else {
            System.out.println("Queue is full");
        }
    }

    void traverse() {
        int i;
        for (i = front; i != rear; i = (i + 1) % capacity) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[i]);
    }

    boolean isEmpty() {
        return front == -1;
    }

    void deQueue() {
        if (!isEmpty()) {
            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % capacity;
        } else {
            System.out.println("Queue is Empty");
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);

        cq.traverse();
        cq.deQueue();
        cq.traverse();
    }
}
