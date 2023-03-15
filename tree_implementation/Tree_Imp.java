public class Tree_Imp {
    Root root;

    Tree_Imp() {
        this.root = null;
    }

    void inOrder(Root node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void preOrder(Root node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Root node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Tree_Imp ti = new Tree_Imp();

        ti.root = new Root(1);
        ti.root.left = new Root(12);
        ti.root.right = new Root(2);
        ti.root.left.left = new Root(5);
        ti.root.right.right = new Root(6);

        ti.inOrder(ti.root);
        System.out.println();
        ti.preOrder(ti.root);
        System.out.println();
        ti.postOrder(ti.root);
    }
}
