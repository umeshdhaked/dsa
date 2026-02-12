package commons.rr_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountIsolatedCommunicationGroups {
        public static int countIsolatedCommunicationGroups(List<List<Integer>> links, int n) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) { 
            adjList.add(new ArrayList<>());
        }

        for(List<Integer> link : links) {
            adjList.get(link.get(0)).add(link.get(1));
        }

        boolean[] visitedComp = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        int ans = 0;
        for (int i=0; i<n; i++) {

            if(!visitedComp[i]) {
                ans++;

                q.add(i);
                while (!q.isEmpty()) {
                    int startLink = q.poll();
                    if (!visitedComp[startLink]) {
                        visitedComp[startLink] = true;
                        List<Integer> endLink = adjList.get(startLink);
                        q.addAll(endLink);
                    }

                }



            }
        }

        return ans;
    }
}
