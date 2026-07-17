package blind75;

public class FindPeakElement {
    /**
     * A peak element is an element that is strictly greater than its neighbors.
     * Given an integer array nums, find a peak element, and return its index.
     * If the array contains multiple peaks, return the index to any of the peaks.
     * You may imagine that nums[-1] = nums[n] = -∞.
     * O (log n) time complexity and O(1) space complexity.
     */
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    public int findPeak(int[] A, int p, int r){
        // you find it
        if (p == r){
            return p;
        }

        else
        {   
            // find the mid point
            int q = p + (r - p) / 2;
            if(A[q] > A [q + 1]){
                return findPeak(A,p,q);
            }
            else
            {
                return findPeak(A, q + 1, r);
            }
        }
    }
}
