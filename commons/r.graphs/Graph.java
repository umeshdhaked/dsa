

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    public int[][] updateMatrix(int[][] mat) { // BFS
        int m = mat.length;
        int n = mat[0].length;

        boolean visited[][] = new boolean[m][n];
        int ans[][] = new int[m][n];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int i = idx[0];
            int j = idx[1];

            if (i + 1 < m && !visited[i + 1][j]) {
                ans[i + 1][j] = ans[i][j] + 1;
                visited[i + 1][j] = true;
                queue.add(new int[] { i + 1, j });
            }
            if (j + 1 < n && !visited[i][j + 1]) {
                ans[i][j + 1] = ans[i][j] + 1;
                visited[i][j + 1] = true;
                queue.add(new int[] { i, j + 1 });
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                ans[i - 1][j] = ans[i][j] + 1;
                visited[i - 1][j] = true;
                queue.add(new int[] { i - 1, j });
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                ans[i][j - 1] = ans[i][j] + 1;
                visited[i][j - 1] = true;
                queue.add(new int[] { i, j - 1 });
            }
        }

        return ans;
    }
}
