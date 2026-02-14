package commons.s_matrics;

import java.util.LinkedList;
import java.util.Queue;

public class Connect2Islands {

    /*
     * 
     * 
     * You are given an n x n binary matrix grid where 1 represents land and 0
     * represents water.
     * An island is a 4-directionally connected group of 1's not connected to any
     * other 1's. There are exactly two islands in the grid.
     * You may change 0's to 1's to connect the two islands to form one island.
     * Return the smallest number of 0's you must flip to connect the two islands.
     * 
     * Example 1:
     * 
     * Input: grid = [[0,1],[1,0]]
     * Output: 1
     * Example 2:
     * 
     * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
     * Output: 2
     * Example 3:
     * 
     * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
     * Output: 1
     * 
     * 
     * 
     */

    public static void main(String[] args) {

        int[][] input1 = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 0, 1 }

        };

        int[][] input2 = new int[][] { { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };

        int ans = new Connect2Islands().getMinimumSwitch(input1);
        System.out.println(ans);
        ans = new Connect2Islands().getMinimumSwitch(input2);
        System.out.println(ans);

    }

    public class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int getMinimumSwitch(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> queue2 = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    queue2.add(new Pair(i, j));
                    visited[i][j] = true;
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            int i = p.i;
            int j = p.j;

            if (i + 1 < n && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                Pair temp = new Pair(i + 1, j);
                queue.add(temp);
                queue2.add(temp);
            }
            if (i - 1 > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                Pair temp = new Pair(i - 1, j);
                queue.add(temp);
                queue2.add(temp);
            }
            if (j + 1 < m && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                Pair temp = new Pair(i, j + 1);
                queue.add(temp);
                queue2.add(temp);
            }
            if (j - 1 > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                Pair temp = new Pair(i, j - 1);
                queue.add(temp);
                queue2.add(temp);
            }
        }

        int count = 0;

        boolean ifFound = false;
        while (!queue2.isEmpty()) {
            int size = queue2.size();

            for (int k = 0; k < size; k++) {

                Pair islandIdx = queue2.poll();
                int i = islandIdx.i;
                int j = islandIdx.j;

                if (i + 1 < n && !visited[i + 1][j]) {
                    if (grid[i + 1][j] == 1) {
                        ifFound = true;
                        break;
                    }
                    queue2.add(new Pair(i + 1, j));
                    visited[i + 1][j] = true;
                }
                if (i - 1 > 0 && !visited[i - 1][j]) {
                    if (grid[i - 1][j] == 1) {
                        ifFound = true;
                        break;
                    }
                    queue2.add(new Pair(i - 1, j));
                    visited[i - 1][j] = true;
                }
                if (j + 1 < m && !visited[i][j + 1]) {
                    if (grid[i][j + 1] == 1) {
                        ifFound = true;
                        break;
                    }
                    queue2.add(new Pair(i, j + 1));
                    visited[i][j + 1] = true;
                }
                if (j - 1 > 0 && !visited[i][j - 1]) {
                    if (grid[i][j - 1] == 1) {
                        ifFound = true;
                        break;
                    }
                    queue2.add(new Pair(i, j - 1));
                    visited[i][j - 1] = true;
                }

            }

            if (ifFound) {
                break;
            }

            count++;
        }

        return count;
    }

}
