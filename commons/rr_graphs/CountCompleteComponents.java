package commons.rr_graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountCompleteComponents {
    
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visitedComp = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {

            int numberOfNode = 0;
            int numberOfEdge = 0;

            if (!visitedComp[i]) {
                q.add(i);

                while (!q.isEmpty()) {
                    int startNode = q.poll();
                    if (!visitedComp[startNode]) {
                        numberOfNode++;
                        visitedComp[startNode] = true;
                        List<Integer> endNodeOfEdge = adjList.get(startNode);
                        numberOfEdge = numberOfEdge + endNodeOfEdge.size();
                        q.addAll(endNodeOfEdge);
                    }

                }
                
                if (numberOfNode*(numberOfNode-1) == numberOfEdge) {
                    ans++;
                }

            }
        }

        return ans;
    }

}
