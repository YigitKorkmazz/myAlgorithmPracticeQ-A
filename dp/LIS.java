package dp;
public class LIS {
    //Given an integer array nums, return the length of the longest strictly increasing subsequence.
    //BOTTOM UP DP SOLUTION
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0 ; i < n; i++){
            dp[i] = 1;
        }

        for (int i = 1; i < n; i ++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < dp.length; i++)
        {
            if (dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}
