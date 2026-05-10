package dp;

public class maximalSquare {
    /**
     * Given an m x n binary matrix filled with 0's and 1's,
     * find the largest square containing only 1's and return its area.
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxSide = 1;
            }
            
        }

        for (int j = 0; j < n; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxSide = 1;
            }
        }
        
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
