package blind75;

import java.util.HashMap;

public class maxOp {
    /*
     * Given an array of integers nums and an integer k,
    return the maximum number of operations you can perform.
     * In each operation,
    you can pick two numbers from the array whose sum equals k and remove them from the array.
     */
     public int maxOperations(int[] nums, int k) {
       int count = 0;
       int n = nums.length;
       //num freq
       HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
       for (int i = 0; i < n; i++){
            int pair = map.getOrDefault(k - nums[i], 0);
            if (pair != 0){
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
                count++;
            }
            else
            {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
       } 

       return count;
    }
}
