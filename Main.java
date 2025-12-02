import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Main().cloneGraph(null);

    }

    public Node cloneGraph(Node node) {

        Node ans = new Node(node.val);

        cloneGraphHelper(node, ans);

        return ans;
    }


    public Node cloneGraphHelper(Node old, Node ans) {
        if (old == null) {
            return null;
        }

        Node node = new Node(old.val);
        for (Node n : old.neighbors) {
            ans.neighbors.add(cloneGraphHelper(n, ans));
        }
        return node;
    }


    /*
        [[2,4],[1,3],[2,4],[1,3]] 

        1 -> 2,4
            2 -> 1,3         <- circular graph / bi-directional graph. 
                    3 -> 2,4
                            4 -> 1,3
    */



    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}