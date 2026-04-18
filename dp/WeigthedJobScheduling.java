package dp;

import java.util.Arrays;

public class WeigthedJobScheduling {
    /* Given a set of N jobs where each job has a start time, end time, and profit associated with it.
     * The task is to find the maximum profit and the number of jobs done.
    */
    public static int maxProfit(int[][] jobs) {
        //we cannot use greedy here
        //we should use bottom-up dp
        //then the problem will be similar to 0-1 knapsack
        int n = jobs.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        //sort jobs in non-decreasing order by their end time
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[1], b[1]));
        
        for (int j = 1; j <= n; j++){
            int take = 0;
            int notTake = 0;
            int i = j - 1;
            //finding the largest index i which is < j and compatible with event j
            while (i > 0 && jobs[i - 1][1] > jobs[j - 1][0]){
                i--;
            }
            
            take = jobs[j - 1][2] + dp[i];
            notTake = dp[j - 1];
            dp[j] = Math.max(take, notTake);
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
         int[][] jobs = {
                {1, 2, 50},
                {3, 5, 20},
                {6, 19, 100},
                {2, 100, 200}
         };

        System.out.println(maxProfit(jobs));
    }
}
