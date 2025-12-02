package questions;

public class MaximumSquareInMetrics {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] mat = new int[row][col];

        for (int i=1;i<col;i++) {
           mat[0][i] = Math.min((int)matrix[0][i-1],(int)matrix[0][i]);
        }
        for (int j=1;j<row;j++) {
           mat[j][0] = Math.min((int)matrix[j-1][0],(int)matrix[j][0]);
        }

        
        for (int j=1;j<matrix.length;j++) {
            for (int i=1;i<matrix[0].length;i++) {
                mat[i][j] = mat[i-1][j-1] + Math.min((int)matrix[i][j],Math.min(mat[i-1][j], mat[i][j-1]));
            }
        }
        return mat[row-1][col-1];
    }
    
}
