package dp;
public class CombinationSum4 {
    /*
    Given an array of distinct integers nums and a target integer target,
    return the number of possible combinations that add up to target.
    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1 ; i <= target; i++){
            dp[i] = 0;
        }

        for (int ptr = 1; ptr <= target; ptr++){
            for (int i = 0; i < nums.length; i++){
                int num = nums[i];
                if (ptr - num >= 0){
                    dp[ptr] = dp[ptr] + dp[ptr-num];
                }
            }
        }

        return dp[target];
    }
}
