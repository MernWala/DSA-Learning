class Root {
    int data;
    Root left, right;

    Root() {
    }

    Root(int data) {
        this.data = data;
    }
}

public class Tree {
    Root root;

    void inOrder(Root node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void postOrder(Root node) {
        if (node == null)
            return;

        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.data + " ");
    }

    void preOrder(Root node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        inOrder(node.left);
        inOrder(node.right);
    }

    // FBT -> Full binary tree
    boolean isFBT(Root node) {
        boolean status = false;
        if (node == null) {
            status = true;
        }

        if (node.right == null && node.left == null) {
            status = true;
        }

        if (node.left != null && node.right != null) {
            if (isFBT(node.left) && isFBT(node.right)) {
                status = true;
            }
        }

        return status;
    }

    // PBT -> Perfect binary tree
    boolean isPBT(Root node) {
        boolean status = false;
   
        return status;
    }

    public static void main(String[] args) {
        Tree obj = new Tree();

        obj.root = new Root(8);
        obj.root.left = new Root(3);
        obj.root.right = new Root(10);
        obj.root.left.left = new Root(1);
        obj.root.left.right = new Root(6);
        obj.root.left.right.left = new Root(4);

        // System.out.print("Pre-Order traversal\t:\t");
        // obj.preOrder(obj.root);
        // System.out.println();

        System.out.print("In-Order Traversal\t:\t");
        obj.inOrder(obj.root);
        System.out.println();

        // System.out.print("Post-Order Traversal\t:\t");
        // obj.postOrder(obj.root);
        // System.out.println();

        // System.out.println(obj.isFBT(obj.root));
    }
}