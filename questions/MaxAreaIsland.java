package questions;

public class MaxAreaIsland {
    
    public int maxAreaOfIslandDFS(int[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i< m ;i++) {
            for (int j =0;j<n;j++) {
                int curAns = maxAreaOfIsland(grid, i, j, new int[m][n]);
                ans = Math.max(ans, curAns);

            }
        }


        return ans;
    }

    private int maxAreaOfIsland(int[][] grid, int m, int n, int[][] visited) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
            return 0;
        }

        if (grid[m][n] == 1 && visited[m][n] == 0) {
            visited[m][n] = 1;
            return 1 
                + maxAreaOfIsland(grid, m-1,n,visited) 
                + maxAreaOfIsland(grid, m,n-1,visited)
                + maxAreaOfIsland(grid, m+1,n,visited)
                + maxAreaOfIsland(grid, m,n+1,visited);
        }
        return 0;
    }
}
