package dp;

public class LongestPalindromicSubsequence {
    /**
     * Given a string s, find the length of the longest palindromic subsequence in s.
     * O(n^2) time complexity and O(n^2) space complexity.
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n -1 ; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
