package blind75;

import java.util.Arrays;

public class nonOverlappingIntervals {
    
    static class interval{
        int start;
        int end;
        interval(int s, int e){
            start = s;
            end = e;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        interval[] events = new interval[n];
        for (int i = 0 ; i < n; i++){
            events[i] = new interval(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a.end, b.end));
        int count = 0;
        int j = 0;
        for (int i = 1; i < n; i++){
            if (events[j].end <= events[i].start){
                j = i;
            }
            else
            {
                count++;
            }
        }

        return count;
    }
}
