import java.util.ArrayList;
import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    void displayNode() {
        System.out.print(data + " ");
    }

    Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }
}

public class LinkListQuestion {
    Node head;
    static int counter = 0;

    void insertAtHead(int data) {
        Node n = new Node();
        n.data = data;
        n.next = head;
        head = n;
    }

    void insertAtTail(int data) {
        if (head == null) {
            insertAtHead(data);
        } else {
            Node n = new Node();
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            n.data = data;
            current.next = n;
        }
    }

    void traverse() {
        Node temp = head;
        while (temp != null) {
            ++counter;
            temp.displayNode();
            temp = temp.next;
        }
        System.out.println();
    }

    void shiftHeadToEnd() {
        Node temp = head;
        insertAtTail(temp.data);
        head = head.next;
    }

    void swapHeadTailNode() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        int temp = head.data;
        head.data = current.data;
        current.data = temp;
    }

    int searchLinkList(int key) {
        Node currNode = head;
        int counter = 0;

        while (currNode.next != null) {
            if (currNode.data == key) {
                return counter;
            }
            currNode = currNode.next;
            ++counter;
        }
        return -1;
    }

    void searchAndDelete(int key) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    void inserAtIndex(int pos, int data) {
        if (pos == 0 || pos == 1) {
            insertAtHead(data);
        } else {
            Node current = head;
            int counter = 0;
            pos--;
            while (current.next != null && counter != (pos - 1)) {
                current = current.next;
                counter++;
            }
            Node n = new Node();
            n.next = current.next;
            current.next = n;
            n.data = data;
        }
    }

    void removeHeadNode() {
        head = head.next;
    }

    void removeTailNode() {
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    void removeIndexNode(int pos) {
        if (pos == 0 || pos == 1) {
            removeHeadNode();
        } else {
            pos--;
            Node curr = head;
            while (curr.next != null && pos != 1) {
                curr = curr.next;
                pos--;
            }
            curr.next = curr.next.next;
        }
    }

    void reverseLinkList() {
        Node curr = head;
        ArrayList<Integer> obj = new ArrayList<>();
        while (curr.next != null) {
            obj.add(curr.data);
            curr = curr.next;
        }

        obj.add(curr.data);
        curr = head;

        for (int i = obj.size() - 1; i >= 0; i--) {
            curr.data = obj.get(i);
            curr = curr.next;
        }
    }

    int palindromLinkList() {
        Node curr = head;
        ArrayList<Integer> obj = new ArrayList<>();

        while (curr.next != null) {
            obj.add(curr.data);
            curr = curr.next;
        }
        obj.add(curr.data);

        int i = 0;
        int j = obj.size() - 1;
        int counter = obj.size() / 2;
        while (counter >= 0) {
            if (obj.get(i) != obj.get(j)) {
                return -1;
            }
            i++;
            j--;
            counter--;
        }
        return 1;
    }

    // worst approch
    Node removeParticualVal(Node head, int val) {
        Node header = new Node();
        Node ref = header;

        Node t1 = head;
        while (t1 != null) {
            if (t1.data != val) {
                // insertAtEnd
                if (ref == null) {
                    header.data = t1.data;
                } else {
                    Node curr = header;
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    Node n = new Node(t1.data);
                    curr.next = n;
                }
            }
            t1 = t1.next;
        }

        return ref.next;
    }

    // better approach
    public Node removeElements(Node head, int val) {
        Node header = new Node(Integer.MIN_VALUE, head);
        Node curr = header;
        while (curr.next != null) {
            if (curr.next.data == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return header.next;
    }

    public Node deleteDuplicates(Node head) {
        HashSet<Integer> hs = new HashSet<Integer>();
        
        Node header = new Node(0);
        Node l1 = head;

        while (l1 != null) {
            if (hs.add(l1.data)) {
                Node curr = header;
                while(curr.next != null){
                    curr = curr.next;
                }
                Node n = new Node(l1.data);
                curr.next = n;
                l1 = l1.next;
            } else {
                l1 = l1.next;
            }
        }

        return header.next;
    }

    // Write a function that return a reversed linked list

    public static void main(String[] args) {
        LinkListQuestion obj = new LinkListQuestion();

        obj.insertAtTail(1);
        obj.insertAtTail(1);
        obj.insertAtTail(2);
        obj.insertAtTail(3);
        obj.insertAtTail(3);
        obj.traverse();
        
    }
}
