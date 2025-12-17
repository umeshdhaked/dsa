import pojo.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {




        return null;
    }

    public TreeNode buildTreeHelper(int[] preorder, int start1, int end1,  int[] inorder, int start2, int end2) {

        if (start1 > end1 && start2 > end2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start1]);


        int remaining = (start1 + end1)/2;
        


        root.left = buildTreeHelper(preorder, start1+1, end1, inorder, start2, end2);
        root.right = buildTreeHelper(preorder, start1, end1, inorder, start2, end2);


        return root;

    }



}