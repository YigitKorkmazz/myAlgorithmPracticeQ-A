package dp;

public class BinaryKnapsack {
    /*
    Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
    The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
    Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.
    */
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int [n + 1][W + 1];
        for (int i = 0 ; i <= n; i++){
            for (int j = 0; j <= W; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else
                {
                    int pick = 0;
                    int notPick = 0;
                    if(j - wt[i - 1] >= 0){
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    }
                    
                    notPick = dp[i - 1][j];
                    
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        
        return dp[n][W];
    }
}
