import java.util.HashMap;
import java.util.Map;

import pojo.TreeNode;

public class CreateTreeII {


    public static void main(String[] args) { 
        System.out.println("Starting Programme....");

        System.out.println("");


        int[] arr1 = new int[]{10,20,40,80,50,30,60,70};
        int[] arr2 = new int[]{80,40,20,50,10,60,30,70};

        TreeNode root = new CreateTreeII().buildTree(arr1, arr2);

        new CreateTreeII().inorder(root);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> mp = new HashMap<>();
        for (int i =0;i<inorder.length;i++){
            mp.put(inorder[i], i);
        }

        int n = inorder.length;

        TreeNode ans = buildTreeHelper(preorder, 0, n-1, mp, 0, n-1);

        return ans;
    }

    public TreeNode buildTreeHelper(int[] preorder, int start1, int end1,  Map<Integer,Integer> inorder, int start2, int end2) {

        if (start1 > end1 && start2 > end2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start1]);


        int inOrderIndex = inorder.get(preorder[start1]);
        


        root.left = buildTreeHelper(preorder, start1+1, start1+ (inOrderIndex-start2), inorder, start2, inOrderIndex-1);
        root.right = buildTreeHelper(preorder, start1 + (inOrderIndex-start2) + 1, end1, inorder, inOrderIndex+1, end2);


        return root;

    }




    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

}