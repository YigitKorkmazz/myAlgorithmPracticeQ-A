package blind75;

public class FindPivotIndex {
    /**
     * Given an array of integers nums, calculate the pivot index of this array.
     * The pivot index is the index where the sum of all the numbers strictly to the left
     * is equal to the sum of all the numbers strictly to the right of the index.
     * O (n) time complexity and O(1) space complexity.
     */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;

        int total = 0;
        for (int i = 0 ; i < n; i++){
            total += nums[i];
        }

        int without = (total - nums[0]);
        if (without % 2 == 0 && without / 2 == 0){
            return 0;
        }

        for (int i = 1; i < n; i++){
            leftSum  += nums[i - 1];
            without = (total - nums[i]);            
            if (without % 2 == 0 && without / 2 == leftSum)
            {
                return i;
            }
        }

        return -1;
    }
}
