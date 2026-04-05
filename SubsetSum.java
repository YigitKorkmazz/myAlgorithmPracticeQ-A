public class SubsetSum {
    /*
    Given an array of positive integers arr[] and a value sum,
    determine if there is a subset of arr[] with sum equal to given sum. 
    */
    class Solution {

        static Boolean isSubsetSum(int arr[], int sum) {
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 1 ; i <= sum; i++){
                dp[i] = false;
            }
            
            int n = arr.length;
            
            for (int i = 0; i < n ; i++){
                for (int s = sum; s >= arr[i]; s--){
                    if (dp[s-arr[i]]){
                        dp[s] = true;
                    }
                }
            }
            
            return dp[sum];
        }
        
    }
}
