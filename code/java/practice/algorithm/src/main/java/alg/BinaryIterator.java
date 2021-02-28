package alg;

import java.util.ArrayList;
import java.util.List;

public class BinaryIterator {
    public int[][] threeOrders(TreeNode root) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        preIterator(root, list1);
        preIterator(root, list2);
        preIterator(root, list3);

        int[][] res = new int[3][list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);
        }
        return res;


    }

    private void preIterator(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        preIterator(root.left, list);
        preIterator(root.right, list);
    }

    private void midIterator(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preIterator(root.left, list);
        list.add(root.value);
        preIterator(root.right, list);
    }

    private void afterIterator(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preIterator(root.left, list);
        preIterator(root.right, list);
        list.add(root.value);
    }

}
