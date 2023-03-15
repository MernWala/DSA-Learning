public class recursion {
    static void show(int a) {
        if (a <= 5) {
            System.out.print(a + " ");
            show(a + 1);
        }
    }

    static void show2(int a) {
        if (a <= 5) {
            System.out.print(a + " ");
            show(a + 1);
        }
    }

    static void treeRecursion(int a) {
        if (a <= 5) {
            System.out.print(a + " ");
            show(a + 1);
            show(a + 1);
        }
    }

   static void reverseNumber(int[] arr, int i){
        if(arr.length == i){
            return;
        }else{
            reverseNumber(arr, i + 1);
            System.out.print(arr[i] +  " ");
        }
    }

    public static void main(String[] args) {
        // show(1); // 1 2 3 4 5
        // treeRecursion(1);

        int[] arr = {1, 2, 3, 4, 5};

        reverseNumber(arr, 0);
    }
}
