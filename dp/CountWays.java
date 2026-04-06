class Solution {
    /*Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
    Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
    Answers are guaranteed to fit into a 32-bit integer.  */
    public int count(int coins[], int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1 ; i <= sum; i++){
            dp[i] = 0;
        }
        
        int n = coins.length;
        for (int i = 0; i < n; i++){
            int coin = coins[i];
            
            for (int j = coin; j <= sum; j++){
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        
        return dp[sum];
    }
}