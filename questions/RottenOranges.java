package questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

        public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<m;i++) {
            for (int j =0;j<n;j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i,j});
            }
        }

        if (queue.isEmpty()) {
            for (int i=0;i<m;i++) {
                for (int j =0;j<n;j++) {
                    if (grid[i][j] == 1) return -1;
                }
            }
            return 0;
        }

        int count = 0;
        Queue<int[]> temp = new LinkedList<>();
        while (!queue.isEmpty()) {

            int[] cord = queue.poll();
            int i = cord[0];
            int j = cord[1];

            if (i + 1 < m && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 2;
                temp.add(new int[] { i + 1, j });
            }
            if (j + 1 < n && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 2;
                temp.add(new int[] { i, j + 1 });
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 2;
                temp.add(new int[] { i - 1, j });
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 2;
                temp.add(new int[] { i, j - 1 });
            }

            if (queue.isEmpty()) {
                while (!temp.isEmpty()) {
                    queue.add(temp.poll());
                }
                count++;
            }
        }

        for (int i=0;i<m;i++) {
            for (int j =0;j<n;j++) {
                if (grid[i][j] == 2) return -1;
            }
        }


        return count;
    }
    
}
