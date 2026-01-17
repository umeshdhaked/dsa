

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST {

    /*
     * BST tree representation.
     * -----------6
     * -------/---|---\
     * ----3------|------10
     * --2-|--4---|---8---|-----14
     * 1-|-|--|-5-|-7-|-9-|--11--|--15
     * 
     * 
     */

    /*
     * Create Tree
     * Tree Traversal -> Inorder/Preorder/PostOrder, Spiral Level Order, Level Order
     * View or tree -> Left View, Right View, Top View
     * 
     * 
     * Seach in BST.
     * Delete Node From tree
     * Burning Tree.
     * Lowest Common Ancister.
     */

    class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
        }
    }

    public void execute() {

        Tree root = new Tree(6);
        root.left = new Tree(3);
        root.left.left = new Tree(2);
        root.left.right = new Tree(4);
        root.left.right.right = new Tree(5);
        root.left.left.left = new Tree(1);

        root.right = new Tree(10);
        root.right.left = new Tree(8);
        root.right.right = new Tree(14);

        root.right.left.left = new Tree(7);
        root.right.left.right = new Tree(9);

        root.right.right.left = new Tree(11);
        root.right.right.right = new Tree(15);

        traversalBFSSpiral(root);

        // traversal-> inorder(sorting), preorder(copying), postorder(deletion).

        // Spiral Tree traversal -> 2 stack, queue and stack.

        // height (total level), and level width.

        // add value in tree.

        // find all data for range.

        // lowestCommonAncister.

        // remove number.

    }

    // DFS
    public void traversalDFS(Tree root) {
        if (root == null) {
            return;
        }

        traversalDFS(root.left);
        System.out.println(root.value);
        traversalDFS(root.right);
    }

    // BFS
    public void traversalBFS(Tree root) {

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree tree = queue.poll();

            System.out.println(tree.value);

            if (null != tree.left) {
                queue.add(tree.left);
            }

            if (null != tree.right) {
                queue.add(tree.right);
            }
        }
    }

    public List<List<Integer>> levelOrverTraversal(Tree tree) {

        List<List<Integer>> ans = new ArrayList<>();

        if (null == tree) {
            return ans;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            ArrayList<Integer> levelElement = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Tree val = queue.poll();

                if (val != null) {
                    levelElement.add(val.value);
                }

                if (val != null && val.left != null) {
                    queue.add(val.left);
                }

                if (val != null && val.right != null) {
                    queue.add(val.right);
                }
            }
            ans.add(levelElement);

        }

        return ans;
    }

    // BFS Spiral
    public void traversalBFSSpiral(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        Stack<Tree> stack = new Stack<>();
        queue.add(root);

        int i = 0;
        while (!queue.isEmpty()) {
            Tree tree = queue.poll();

            System.out.println(tree.value);

            if (i % 2 == 0) {
                if (null != tree.left) {
                    stack.add(tree.left);
                }
                if (null != tree.right) {
                    stack.add(tree.right);
                }
            } else {
                if (null != tree.right) {
                    stack.add(tree.right);
                }
                if (null != tree.left) {
                    stack.add(tree.left);
                }
            }

            if (queue.isEmpty()) {
                i++;
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
            }
        }
    }

}