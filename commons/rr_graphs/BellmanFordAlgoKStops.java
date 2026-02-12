package commons.rr_graphs;

import java.util.Arrays;

public class BellmanFordAlgoKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize distance array with infinity
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // cost to reach source is 0

        // Relax edges up to k + 1 times (since k stops means k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n); // copy previous distances
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w; // update cheaper cost
                }
            }
            dist = temp; // move to next iteration
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    
}
