package greedy;

import java.util.Arrays;

public class maxUnits {
    /**
     * You are assigned to put some amount of boxes onto one truck.
     * You are given a 2D array boxTypes,
     * where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
     * numberOfBoxesi is the number of boxes of type i.
     * numberOfUnitsPerBoxi is the number of units in each box of the type
     * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
     * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
     * Return the maximum total number of units that can be put on the truck.
     * O(nlogn) time complexity and O(n) space complexity, where n is the length of the input array boxTypes.
     */
    
    static class box{
        int no;
        int unit;
        box(int n, int u){
            no = n;
            unit = u;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        box[] boxes = new box[n];

        for (int i = 0 ; i < n ; i++){
            boxes[i] = new box (boxTypes[i][0], boxTypes[i][1]);
        }

        Arrays.sort(boxes, (a,b) -> Integer.compare(b.unit, a.unit));
        int i = 0;
        int remaining = truckSize;
        int sum = 0;
        while (i < n && remaining > 0){
            int number = boxes[i].no;
            int unit = boxes[i].unit;
            if (number <= remaining){
                remaining -= number;
                sum += unit * number;
            }
            else
            {
                int used = 1;
                while (used <= remaining){
                    used++;
                }

                used--;
                remaining -= used;
                sum += used * unit;
            }

            i++;
        }

        return sum;
    }
}
