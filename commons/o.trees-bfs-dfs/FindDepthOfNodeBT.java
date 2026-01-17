package questions;

import pojo.Node;

public class FindDepthOfNodeBT {

    int findDepth(Node root, int value) {
        
        if (root.data == value) {
            return 0;
        }

        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        findDepth(root, value, ans);

        return ans[0];
    }


    int findDepth(Node root, int value, int[] ans) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.data == value) {
            return 0;
        }


        int leftFound =  findDepth(root.left, value, ans);
        int rightFound = findDepth(root.right, value, ans);     

        if (leftFound != Integer.MIN_VALUE) {
            ans[0] = Math.max(ans[0],  leftFound + 1);
            return leftFound + 1;
        }
        if (rightFound != Integer.MIN_VALUE) {
            ans[0] = Math.max(ans[0],  rightFound + 1);
            return rightFound + 1;
        }

        return Integer.MIN_VALUE;
    }
    
}
