package dp;

public class EditDistance {
    /**
     * Given two strings s1 and s2,
     * find the minimum number of operations required to convert s1 to s2.
     * We have the following 3 operations permitted on a word:
     * Insert a character
     * Remove a character
     * Replace a character
     * O(n*m) time complexity and O(n*m) space complexity.
     */
    public int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m ; j++){
                if (i == 0){
                    dp[i][j] = j;
                }
                
                else if (j == 0){
                    dp[i][j] = i;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    int min = Math.min(1 + dp[i - 1][j], 1 + dp[i - 1][j - 1]); // compare remove and replace
                    dp[i][j] = Math.min(min, 1 + dp[i][j - 1]); // compare insert
                }
            }
        }
        
        return dp[n][m];
    }
}
