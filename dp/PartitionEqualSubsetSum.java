package dp;

public class PartitionEqualSubsetSum {
    /**
     * Given a non-empty array of positive integers nums,
     * determine if the array can be partitioned into two subsets
     * such that the sum of elements in both subsets is equal.
     * O(n * sum) time complexity and O(n * sum) space complexity,
     * where n is the length of the input array nums and sum is the total sum of elements.
     */

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0 ; i < n; i++){
            sum += nums[i];
        }

        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0 ; i <= n; i++){
            dp[i][0] = 0;
        }

        for (int j = 1 ; j <= target; j++){
            dp[0][j] = 0;
        }

        for (int i = 1 ; i <= n; i++){
            for (int j = 1; j <= target; j++){
                int take = 0;
                int notTake = dp[i - 1][j];
                if (nums[i - 1] <= j){
                    take = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                }

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n][target] == target;
    }
}
