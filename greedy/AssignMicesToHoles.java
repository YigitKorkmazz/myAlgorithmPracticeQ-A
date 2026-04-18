package greedy;

import java.util.Arrays;

public class AssignMicesToHoles {
    /**
     * Given two arrays, one representing the positions of mices and the other representing the positions of holes.
     * Each mouse can stay in one hole.
     * The time taken for a mouse to stay in a hole is the distance between the position of the mouse and the position of the hole.
     * Find the minimum time required for all mice to stay in holes.
     * O(nlogn) time complexity and O(1) space complexity GREEDY solution.
     */
    
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int max = 0;
        for (int i = 0 ; i < mices.length; i++){
            if (Math.abs(holes[i] - mices[i]) > max){
                max = Math.abs(holes[i] - mices[i]);
            }
        }
        
        return max;
    }
}
