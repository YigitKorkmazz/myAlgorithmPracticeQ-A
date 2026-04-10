package greedy;

import java.util.Arrays;

/**
 * You are given an array greed[], where greed[i] represents the minimum size of cookie required to satisfy the i-th child,
 * and an array cookie[], where cookie[j] represents the size of the j-th cookie.
 * Each child can receive at most one cookie.
 * A child i will be satisfied if they receive a cookie j such that cookie[j] >= greed[i].
 * Your task is to determine the maximum number of children that can be satisfied.
 */
public class AssignCookies {

    // O(n log n + m log m) time complexity due to sorting, where n is the length of greed and m is the length of cookie arrays.
    public int maxChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);
        
        int n = greed.length;
        int m = cookie.length;
        
        int childIdx = 0;
        int cookieIdx = 0;
        int count = 0;
        while (childIdx < n && cookieIdx < m)
        {
            while (cookieIdx < m && greed[childIdx] > cookie[cookieIdx])
            {
                cookieIdx++;
            }
            
            if (cookieIdx < m && greed[childIdx] <= cookie[cookieIdx]){
                childIdx++;
                cookieIdx++;
                count++;
            }
        }
        
        return count;
        
    }
}
