package challenge.y2021_week13;

// https://leetcode.com/problems/add-one-row-to-tree/
// Add One Row to Tree

import java.util.*;

public class Q02 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int d = 0;
        while (!queue.isEmpty()) {
            if (++d + 1 == depth) {
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode tn = queue.poll();
                    if (tn.left == null && tn.right == null) {
                        TreeNode newLeftTn = new TreeNode(val);
                        TreeNode newRightTn = new TreeNode(val);
                        tn.left = newLeftTn;
                        tn.right = newRightTn;
                    } else {
                        if (tn.left != null) {
                            TreeNode newTn = new TreeNode(val);
                            newTn.left = tn.left;
                            tn.left = newTn;
                        }
                        if (tn.right != null) {
                            TreeNode newTn = new TreeNode(val);
                            newTn.right = tn.right;
                            tn.right = newTn;
                        }
                    }
                }
                break;
            } else {
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode tn = queue.poll();
                    if (tn.left != null) queue.add(tn.left);
                    if (tn.right != null) queue.add(tn.right);
                }
            }
        }

        return root;
    }
}
