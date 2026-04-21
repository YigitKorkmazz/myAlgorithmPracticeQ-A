package greedy;

import java.util.Arrays;

public class nonOverlappingIntervals {
    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     * Greedy solution in O(n log n)
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort intervals by their end time in non-decreasing order
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int n  = intervals.length;
        int count = 0;
        int j = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; i++){
            if (intervals[i][0] >= j){
                count++;
                j = intervals[i][1];
            }
        }

        return n - count;
    }
}
