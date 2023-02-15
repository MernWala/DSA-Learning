import java.util.ArrayList;

class Node {
    int data;
    Node next;

    void displayNode() {
        System.out.print(data + " ");
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

    void removeHeadNode(){
        head = head.next;
    }

    void removeTailNode(){
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
    }

    void removeIndexNode(int pos){
        if(pos == 0 || pos == 1){
            removeHeadNode();
        }else{
            pos--;
            Node curr = head;
            while(curr.next != null && pos != 1){
                curr = curr.next;
                pos--;
            }
            curr.next = curr.next.next;
        }
    }

    void reverseLinkList(){
        Node curr = head;
        ArrayList<Integer> obj = new ArrayList<>();
        while(curr.next != null){
            obj.add(curr.data);
            curr = curr.next;
        }
        
        obj.add(curr.data);
        curr = head;
        
        for(int i=obj.size()-1; i>=0; i--){
            curr.data = obj.get(i);
            curr = curr.next;
        }
    }

    int palindromLinkList(){
        Node curr = head;
        ArrayList<Integer> obj = new ArrayList<>();
        
        while(curr.next != null){
            obj.add(curr.data);
            curr = curr.next;
        }
        obj.add(curr.data);

        int i = 0;
        int j = obj.size()-1;
        int counter = obj.size()/2;
        while(counter >= 0){
            System.out.println(obj.get(i) + " " + obj.get(j));
            if(obj.get(i) != obj.get(j)){
                return -1;
            }
            i++;
            j--;
            counter--;
        }
        return 1;
    }

    public static void main(String[] args) {
        LinkListQuestion obj = new LinkListQuestion();

        obj.insertAtHead(10);
        obj.insertAtHead(11);
        obj.insertAtHead(12);
        obj.insertAtHead(15);
        obj.insertAtHead(12);
        obj.insertAtHead(11);
        obj.insertAtHead(10);

        System.out.println(obj.palindromLinkList());
    }
}
