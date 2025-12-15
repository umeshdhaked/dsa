package commons;

public class MaxLeafDistance {

    public static void main(String[] args) {
        MaxLeafDistance bt = new MaxLeafDistance();

        TreeNode n3 = bt.new TreeNode(3);
        TreeNode n5 = bt.new TreeNode(5);
        TreeNode n1 = bt.new TreeNode(1);
        TreeNode n6 = bt.new TreeNode(6);
        TreeNode n2 = bt.new TreeNode(2);
        TreeNode n7 = bt.new TreeNode(7);
        TreeNode n4 = bt.new TreeNode(4);
        TreeNode n0 = bt.new TreeNode(0);
        TreeNode n8 = bt.new TreeNode(8);

        n3.left = n5;
        n3.right = n1;

        n5.left = n6;
        n5.right = n2;

        n1.left = n0;
        n1.right = n8;

        n2.left = n7;
        n2.right = n4;

        TreeNode root = n3;

        System.out.println("root: " + root.val);
        System.out.println("root.left: " + root.left.val);
        System.out.println("root.right: " + root.right.val);
        System.out.println("root.left.right.left: " + root.left.right.left.val);
        System.out.println("root.left.right.right: " + root.left.right.right.val);



        int dist = bt.maxDistance(root, 1);
        System.out.println(dist);
        dist = bt.maxDistance(root, 2);
        System.out.println(dist);
        dist = bt.maxDistance(root, 3);
        System.out.println(dist);
        dist = bt.maxDistance(root, 4);
        System.out.println(dist);
        dist = bt.maxDistance(root, 5);
        System.out.println(dist);
        dist = bt.maxDistance(root, 6);
        System.out.println(dist);
        dist = bt.maxDistance(root, 7);
        System.out.println(dist);
        dist = bt.maxDistance(root, 8);
        System.out.println(dist);

        
    }


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


    public int maxDistance(TreeNode root, int start) {

        if (root.val == start) {
            return heightOfTree(root);
        }


        int[] res = new int[1];
        dfs(root, start, res);
        return res[0];
    }

    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.right), heightOfTree(root.left));
    }

    // // returns height of subtree and updates max distance
    // private int findLeaf(TreeNode node, int leaf, int[] res) {
    //     if (node == null) return 0;

    //     int left = findLeaf(node.left, leaf, res);
    //     int right = findLeaf(node.right, leaf, res);

    //     // if this node is the target leaf
    //     if (node.val == leaf) {
    //         res[0] = Math.max(res[0], Math.max(left, right));
    //         return 1;
    //     }

    //     // if leaf found in left subtree
    //     if (left > 0 && (node.left != null && contains(node.left, leaf))) {
    //         res[0] = Math.max(res[0], left + right + 1);
    //         return left + 1;
    //     }

    //     // if leaf found in right subtree
    //     if (right > 0 && (node.right != null && contains(node.right, leaf))) {
    //         res[0] = Math.max(res[0], left + right + 1);
    //         return right + 1;
    //     }

    //     return Math.max(left, right) + 1;
    // }

    // private boolean contains(TreeNode node, int leaf) {
    //     if (node == null) return false;
    //     if (node.val == leaf) return true;
    //     return contains(node.left, leaf) || contains(node.right, leaf);
    // }



    // returns int[]{height, distFromStart}
    private int[] dfs(TreeNode node, int start, int[] maxDist) {
        if (node == null) return new int[]{0, -1};

        int[] left = dfs(node.left, start, maxDist);
        int[] right = dfs(node.right, start, maxDist);

        int height = Math.max(left[0], right[0]) + 1;

        int distFromStart = -1;

        // Case 1: current node is the start node
        if (node.val == start) {
            distFromStart = 0;
            maxDist[0] = Math.max(maxDist[0], Math.max(height - 1, maxDist[0]));
        }

        // Case 2: start found in left subtree
        if (left[1] != -1) {
            distFromStart = left[1] + 1;
            // path goes up from left subtree, through this node, down right subtree
            maxDist[0] = Math.max(maxDist[0], Math.max(left[1] + 1 + right[0], maxDist[0]));
        }

        // Case 3: start found in right subtree
        if (right[1] != -1) {
            distFromStart = right[1] + 1;
            maxDist[0] = Math.max(maxDist[0], Math.max(right[1] + 1 + left[0], maxDist[0]));
        }

        return new int[]{height, distFromStart};
    }

}
