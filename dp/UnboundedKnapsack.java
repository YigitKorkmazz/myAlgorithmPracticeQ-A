package dp;

public class UnboundedKnapsack {
    /**
     * Given a set of N items, each with a value val[i] and a weight wt[i],
     * and a knapsack with capacity W, find the maximum total value that can be put in the knapsack.
     * You can use an item multiple times which is different than the original 0-1 knapsack problem.
     * O(n*capacity) time complexity and O(n*capacity) space complexity.
     */
     public int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][]dp = new int [n + 1][capacity + 1];
        
        for (int j = 0; j <= capacity; j++){
            dp[0][j] = 0;
        }
        
        for (int i = 1 ; i <= n; i++){
            for (int j = 0; j <= capacity; j++){
                if (wt[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; // not take
                }
                else
                {
                    int take = dp[i][j - wt[i - 1]] + val[i - 1];
                    int notTake = dp[i - 1][j];
                    
                    dp[i][j] = Math.max(take, notTake);
                }
            }
        }
        
        return dp[n][capacity];
    }
}
