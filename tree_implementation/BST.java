public class BST {
    Root root;

    void insert(int val){
        root = insertValue(root, val);
    }

    Root insertValue(Root root, int val){
        if(root == null){
            root = new Root(val);
        }else if(val < root.data){
            root.left = insertValue(root.left, val);
        }else{
            root.right = insertValue(root.right, val);
        }
        return root;
    }

    void printTree(){
        inOrder(root);
    }

    void inOrder(Root root){
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BST b = new BST();
        
        // 8, 3, 10, 1, 6, 4
        b.insert(8);
        b.insert(3);
        b.insert(10);
        b.insert(1);
        b.insert(6);
        b.insert(4);

        b.printTree();
    }
}
