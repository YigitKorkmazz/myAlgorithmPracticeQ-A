package dp;

public class MinimumFallingPathSum {
    /**
     * Given an n x n array of integers matrix,
     * return the minimum sum of any falling path through matrix.
     * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
     * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
     */
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int [m][n];

        for (int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1 ; i < m; i++){
            for (int j = 0 ; j < n; j++){
                if (j == 0){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                }

                else if (j == n - 1){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j -1]) + matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0 ; j < n ; j++){
            if (min > dp[m - 1][j]){
                min = dp[m - 1][j];
            }
        }

        return min;
    }
}
