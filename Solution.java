import pojo.TreeNode;

class Solution {
    public int minDiffInBST(TreeNode root) {

        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        minDiffInBST(root, null, ans);
        
        return ans[0];
    }

    public void minDiffInBST(TreeNode root, TreeNode previous, int[] ans) {
        if (root == null) {
            return;
        }
        minDiffInBST(root.left, root, ans);

        if (previous != null) {
            ans[0] = Math.min(ans[0], Math.abs(previous.val - root.val));
        }

        minDiffInBST(root.right, root, ans);
    }

}