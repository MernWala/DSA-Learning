import java.util.ArrayList;
import java.util.List;

public class pascalTraiangle {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < 5; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }

        System.out.println(res);
    }
}
