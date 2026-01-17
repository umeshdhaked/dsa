import pojo.TreeNode;

public class CreateTreeI {

    public static void main(String[] args) { 
        System.out.println("Starting Programme....");

        System.out.println("");


        int[] arr = new int[]{10,20,30,40,50,60,70,80};

        TreeNode root = createTree(arr, 1);

        inorder(root);
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.val+",");
        inorder(root.right);
    }

    private static TreeNode createTree(int[] arr, int i) {
        if (i > arr.length) {
            return null;
        }

        TreeNode root = new TreeNode(arr[i-1]);

        root.left = createTree(arr, 2*i);
        root.right = createTree(arr, 2*i+1);

        return root;
    }

}