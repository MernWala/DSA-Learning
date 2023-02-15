import java.util.Scanner;

public class stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        int size = sc.nextInt();
        int top = -1;

        int[] arr = new int[size];

        char ans = 'n';

        while (ans == 'n' || ans == 'N') {
            System.out.println("1. Push\n2. Pop\n3.Show");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (top != size - 1) {
                        top++;
                        arr[top] = sc.nextInt();
                    } else {
                        System.out.println("Stack is full");
                    }
                    break;

                case 2:
                    if (top == -1) {
                        System.out.println("Stack is empty");
                    } else {
                        // arr[top] = 0;        // <-- isn't Manditory;
                        top--;
                    }
                    break;

                case 3:
                    for (int i = 0; i <= top; i++) {
                        System.out.print(arr[i] + " ");
                    }
            }
            System.out.print("Do you want to exit: ");
            ans = sc.next().charAt(0);
        }

    }
}