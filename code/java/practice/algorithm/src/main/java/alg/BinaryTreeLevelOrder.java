package alg;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrder {
    public ArrayList<ArrayList<Integer>> getLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int n = list.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = list.poll();
                assert curNode != null;
                levelList.add(curNode.value);
                if (curNode.left != null) {
                    list.add(curNode.left);
                }
                if (curNode.right != null) {
                    list.add(curNode.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
