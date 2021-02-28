package alg;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> getLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                TreeNode node = queue.poll();
                if ((res.size() + 1) % 2 == 0) {
                    tmp.add(0, node.value);
                } else {
                    tmp.add(node.value);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                res.add(tmp);
            }
        }
        return res;
    }
}
