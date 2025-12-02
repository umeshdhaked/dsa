package questions;

import java.util.ArrayList;
import java.util.List;

public class RangeSumBST {

    public class TreeNode {
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

    public int rangeSumBST(TreeNode root, int low, int high) {

        int sum = 0;
        List<Integer> values = new ArrayList<>();
        rangeSumBST(root, low, high, values);
        for (Integer val : values) {
            if (val >= low || val <= high) {

                sum = sum + val;
            }
        }

        return sum;
    }

    public void rangeSumBST(TreeNode root, int low, int high, List<Integer> values) { //not optimized for space.
        if (root == null) {
            return;
        }
        rangeSumBST(root.left, low, high, values);
        System.out.println(root.val);
        values.add(root.val);
        rangeSumBST(root.right, low, high, values);

    }

}
