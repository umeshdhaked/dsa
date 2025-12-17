package commons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import commons.TreeNode;;

public class BurningTree {


    public static void main(String[] args) {
        
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);

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

        int dist = amountOfTime(root, 1);
        System.out.println(dist);
        dist = amountOfTime(root, 2);
        System.out.println(dist);
        dist = amountOfTime(root, 3);
        System.out.println(dist);
        dist = amountOfTime(root, 4);
        System.out.println(dist);
        dist = amountOfTime(root, 5);
        System.out.println(dist);
        dist = amountOfTime(root, 6);
        System.out.println(dist);
        dist = amountOfTime(root, 7);
        System.out.println(dist);
        dist = amountOfTime(root, 8);
        System.out.println(dist);
    }




    public static int amountOfTime(TreeNode root, int start) {

        int[] ans = new int[1];

        Map<TreeNode, TreeNode> mp = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        mp.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                mp.put(node.left, node);
            }

            if (node.right != null) {
                queue.add(node.right);
                mp.put(node.right, node);
            }
        }

        amountOfTimeFromStart(root, start, ans, mp);

        return ans[0];
    }

    private static int amountOfTimeFromStart(TreeNode root, int start, int[] ans, Map<TreeNode, TreeNode> mp) {

        TreeNode leaf = findNode(root, start);

        Set<TreeNode> visited = new HashSet<>();

         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(leaf);

         Queue<TreeNode> temp = new LinkedList<>();
         while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null && !visited.contains(node.left)) {
                temp.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                temp.add(node.right);
            }
            if (mp.get(node) != null && !visited.contains(mp.get(node))) {
                temp.add(mp.get(node));
            }

            visited.add(node);

            if (queue.isEmpty()) {
                ans[0] = ans[0] + 1;
                queue.addAll(temp);
                temp.clear();
            }
            
         }

        return ans[0];
    }

    public static TreeNode findNode(TreeNode root, int target) {
        if (root == null)
            return null;
        if (root.val == target)
            return root;
        TreeNode left = findNode(root.left, target);
        if (left != null)
            return left;
        TreeNode right = findNode(root.right, target);
        if (right != null)
            return right;
        return left != null ? left : right;
    }
    
}
