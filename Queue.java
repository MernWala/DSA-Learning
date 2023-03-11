import java.util.Scanner;

public class Queue {
    static int[] arr;
    static int front, rear;

    Queue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public static boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFull() {
        if (rear == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    // insertion
    public void enqueue(int a) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1)
                front = 0;
            arr[++rear] = a;
        }
    }

    // delete
    public void dqueue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
        } else {
            if(front >= rear){
                arr[front] = 0;
                front = -1;
                rear = -1;
            }else{
                arr[front] = 0;
                front++;
            }
        }
    }

    public void traverse() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Size of queue: ");
        int size = sc.nextInt();
        Queue obj = new Queue(size);
        boolean ans = true;

        while (ans) {

            System.out.println("|-------------|");
            System.out.println("|--- Menue ---|");
            System.out.println("|-------------|\n");

            System.out.println("1. Enqueue\n2.Dequeue\n3.Traverse\n4.Exit Program");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    obj.enqueue(sc.nextInt());
                    break;

                case 2:
                    obj.dqueue();
                    break;

                case 3:
                    obj.traverse();
                    break;

                case 4:
                    System.out.println("Bye :)");
                    System.exit(0);
                    break;

                default:
                    System.out.println("You have entred wrong choice ..!");
            }

            System.out.print("Do you want to continue: ");
            char temp = sc.next().charAt(0);
            ans = (temp == 'y' || temp == 'Y') ? true : false;
        }

        sc.close();
    }
}