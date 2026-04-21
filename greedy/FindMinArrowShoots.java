package greedy;

import java.util.Arrays;

public class FindMinArrowShoots {
    /**
     * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
     * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend.
     * You do not know the exact y-coordinates of the balloons
     * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
     * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows
     * Greedy solution in O(n log n)
     */
    
    public int findMinArrowShots(int[][] points) {
        //sort the baloons by their end in non-decreasing order
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int n = points.length;
        int count = 1;
        int lastShoot = 0;

        for (int i = 1 ; i < n; i++){
            if (points[i][0] > points[lastShoot][1]){
                lastShoot = i;
                count++;
            }
        }

        return count;
    }
}
