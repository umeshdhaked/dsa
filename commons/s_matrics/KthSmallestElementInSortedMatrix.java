package commons.s_matrics;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public class Cord {
        int i;
        int j;
        int val;
        public Cord(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Cord> queue = new PriorityQueue<Cord>((a,b)-> {return a.val - b.val;});
        queue.add(new Cord(0, 0, matrix[0][0]));
        visited[0][0]= true;


        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty() && k>0) {
            Cord c = queue.poll();
            int i = c.i;
            int j = c.j;

            if (i+1<matrix.length && !visited[i+1][j]) {
                queue.add(new Cord(i+1, j, matrix[i+1][j]));
                visited[i+1][j]= true;
            }
            if (j+1<matrix.length && !visited[i][j+1]) {
                queue.add(new Cord(i, j+1, matrix[i][j+1]));
                visited[i][j+1]= true;
            }
            k--;
            ans = c.val;
        }

        return ans;
    }
}
