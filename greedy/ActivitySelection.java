package greedy;

import java.util.Arrays;

public class ActivitySelection {
    /**
     * You are given two arrays, start[] and finish[]
     * where start[i] and finish[i] represent the start and finish times of the i-th activity, respectively.
     * Your task is to determine the maximum number of non-overlapping activities that can be performed by a single person, assuming that a person can only work on one activity at a time.
     * Return the maximum number of activities that can be performed.
     */
    static class activity{
        int start;
        int finish;
        
        activity(int s, int f){
            start = s;
            finish = f;
        }
    }
    
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        activity[] activities = new activity[n];
        for (int i = 0 ; i < n; i++){
            activities[i] = new activity(start[i], finish[i]);
        }
        
        // O(n log n) time complexity due to sorting, where n is the length of the start and finish arrays.
        Arrays.sort(activities, (a, b) -> Integer.compare(a.finish, b.finish));
        int count = 1;
        int j = 0;
        
        for (int i = 1; i < n; i++){
            if (activities[i].start > activities[j].finish){
                count++;
                j = i;
            }
        }
        
        return count;
    }
}
