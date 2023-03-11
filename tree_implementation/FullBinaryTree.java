public class FullBinaryTree {
    Node root;

    boolean isFull(Node node) {
        boolean status = false;
        if (node == null)
            status = true;

        if (node.left == null && node.right == null)
            status = true;

        if (node.left != null && node.right != null) {
            if ((isFull(node.left)) && (isFull(node.right))) {
                status = true;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        FullBinaryTree fbt = new FullBinaryTree();
        fbt.root = new Node(1);
        fbt.root.left = new Node(2);
        fbt.root.right = new Node(3);
        fbt.root.left.left = new Node(4);
        fbt.root.left.right = new Node(5);
        fbt.root.right.right = new Node(6);
        fbt.root.right.left = new Node(7);
        System.out.println(fbt.isFull(fbt.root));

    }
}
