package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * O(nlogn) time complexity and O(1) space complexity GREEDY solution.
     */
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res= new ArrayList<>();
        
        int j = 0;
        res.add(arr[0]);
        
        for (int i = 1 ; i < arr.length; i++){
            if (arr[i][0] <= arr[j][1])
            {
                if (arr[j][1] < arr[i][1]){
                    int[] temp = res.get(res.size() - 1);
                    temp[1] = arr[i][1];
                    j = i;
                    res.set(res.size() - 1, temp);
                }
                
            }
            
            else
            {
                res.add(arr[i]);
                j = i;
            } 
        }
    
        return res;
        
    }
}
