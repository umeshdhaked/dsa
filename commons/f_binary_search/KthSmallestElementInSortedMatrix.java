package commons.f_binary_search;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int minVal = matrix[0][0];
        int maxVal = matrix[n - 1][n - 1];

        while (minVal < maxVal) {

            int midVal = minVal + (maxVal-minVal)/2;
            int countToReach = counts(matrix, midVal);

            if (countToReach >= k) {
                maxVal = midVal;
            } else {
                minVal = midVal+1;
            }
        }

        return minVal;
    }

    private int counts(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}