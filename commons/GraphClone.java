package commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphClone {


    public Node cloneGraph(Node node) {

        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node ans = cloneGraphHelper(node, oldToNewMap);

        return ans;
    }


    public Node cloneGraphHelper(Node old, Map<Node, Node> oldToNewMap) {
        if (old == null) {
            return null;
        }

        if (oldToNewMap.containsKey(old)) {
            return oldToNewMap.get(old);
        }
        Node node = new Node(old.val);
        oldToNewMap.put(old, node);


        for (Node n : old.neighbors) {
            node.neighbors.add(cloneGraphHelper(n, oldToNewMap));
        }

        return node;
    }

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
