package dp;

public class maxSubarrayProblem {
    /**
     * Given an integer array nums,
     * find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     * O(n) time complexity and O(n) space complexity,
     * where n is the length of the input array nums.
     */
    
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n ;i++){
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }
            else
            {
                dp[i] = dp[i - 1] + nums[i];
            }

            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}
