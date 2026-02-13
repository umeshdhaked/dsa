package commons.o_trees_bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

import commons.o_trees_bfs_dfs.RangeSumBST.TreeNode;

public class CountInCompleteTree {


    public int countNodesNaive(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int count =0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                count++;
                queue.add(node.left);
            }
            if (node.right != null) {
                count++;
                queue.add(node.right);
            }
        }

        return count;
    }


    //##############################################################################

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = leftDistance(root);
        int rightHeight = rightDistance(root);

        if (leftHeight == rightHeight) {
            return ((Double) Math.pow(2, leftHeight)).intValue() - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDistance(TreeNode root) {
        TreeNode temp = root;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.left;
        }
        return count;
    }

    private int rightDistance(TreeNode root) {
        TreeNode temp = root;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.right;
        }
        return count;
    }

}
