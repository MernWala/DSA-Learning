public class doblyLinkedList {

    class Node {
        Node prev;
        int data;
        Node next;

        void displayNode() {
            System.out.print(data + " ");
        }
    }

    Node head, tail;

    void insertAtHead(int data) {
        Node n = new Node();
        n.data = data;
        n.next = head;
        head = n;
        if (head != null)
            head.prev = n;
        if (tail == null)
            tail = n;
    }

    void insertAtEnd(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        n.prev = tail;
        if (tail != null)
            tail.next = n;
        tail = n;
        if (head == null)
            head = n;
    }

    void traverseHead() {
        Node curr = head;
        while (curr != null) {
            curr.displayNode();
            curr = curr.next;
        }
        System.out.println();
    }

    void deleteHead() {
        if (head == null) {
            System.out.println("list empty");
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteTail() {
        if (tail == null) {
            System.out.println("List empty");
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    boolean isAnagram(Node a, Node b) {
        Node temp1 = a;
        Node temp2 = b;

        int[] arr = new int[26];

        while (temp1 != null && temp2 != null) {
            arr[temp1.data - 'a']++;
            arr[temp2.data - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(arr[i] != 0) return false;
        }

        return true;
    }

    Node mergeThenSort(Node a, Node b){
        return null;
    }

    public static void main(String[] args) {
        doblyLinkedList obj = new doblyLinkedList();

        obj.insertAtHead(10);
        obj.insertAtHead(20);
        obj.insertAtHead(30);

        obj.insertAtEnd(40);
        obj.insertAtEnd(50);
        obj.insertAtEnd(60);

        obj.traverseHead();

        obj.deleteHead();
        obj.traverseHead();
        obj.deleteTail();
        obj.traverseHead();
    }
}
