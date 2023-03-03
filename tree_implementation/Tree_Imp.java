package tree_implementation;

public class Tree_Imp {
    Node root;

    Tree_Imp() {
        this.root = null;
    }

    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Tree_Imp ti = new Tree_Imp();

        ti.root = new Node(1);
        ti.root.left = new Node(12);
        ti.root.right = new Node(2);
        ti.root.left.left = new Node(5);
        ti.root.right.right = new Node(6);

        ti.inOrder(ti.root);
        System.out.println();
        ti.preOrder(ti.root);
        System.out.println();
        ti.postOrder(ti.root);
    }
}

class Node {
    int data;
    Node left, right;

    Node() {
    }

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}