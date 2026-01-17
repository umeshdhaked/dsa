import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DijkestraWithKStops {

    public class Triplet {
        Integer stops;
        Integer sourceFlight;
        Integer cost;

        public Triplet(Integer stop,Integer srcFlight, Integer cost) {
            this.stops = stop;
            this.sourceFlight = srcFlight;
            this.cost = cost;
        }
    }

    public class ToFlight {
        Integer toFlight;
        Integer cost;

        public ToFlight(Integer toflight, Integer cost) {
            this.toFlight = toflight;
            this.cost = cost;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<ToFlight>> adjList = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<flights.length;i++) {
            int[] flightData = flights[i];
            int city1 = flightData[0];
            int city2 = flightData[1];
            int cost = flightData[2];
            adjList.get(city1).add(new ToFlight(city2, cost));
        }

        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(0, src, 0)); //stops, flight, cost

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            Triplet node = queue.poll();

            int stops = node.stops;
            int flight = node.sourceFlight;
            int cost = node.cost;

            if (stops <= k+1 && flight == dst) {
                minCost = Math.min(minCost, cost);
            }
            
            List<ToFlight> conenctingFlights = adjList.get(flight);
            for (int i=0; i< conenctingFlights.size(); i++) {

                ToFlight flightDetail = conenctingFlights.get(i);
                int nextCity = flightDetail.toFlight;
                int costFromSource = cost + flightDetail.cost;

                if (costFromSource < costs[nextCity] && stops < k + 1) {
                    costs[nextCity] = costFromSource;
                    queue.add(new Triplet(stops+1, nextCity, costFromSource));
                } 
            }
            
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
        
    }

}
