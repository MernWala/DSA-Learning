public class FullBinaryTree {
    Root root;

    boolean isFull(Root node) {
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
        fbt.root = new Root(1);
        fbt.root.left = new Root(2);
        fbt.root.right = new Root(3);
        fbt.root.left.left = new Root(4);
        fbt.root.left.right = new Root(5);
        fbt.root.right.right = new Root(6);
        fbt.root.right.left = new Root(7);
        System.out.println(fbt.isFull(fbt.root));

    }
}
