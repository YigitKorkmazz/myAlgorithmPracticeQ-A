package greedy;

import java.util.Arrays;

public class boatsToSavePeople {
    /**
     * Given an array of people's weights and a boat limit,
     * determine the minimum number of boats needed to rescue everyone.
     * O(n log n) time complexity due to sorting, and O(1) space complexity.
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int j = n - 1;
        int i = 0;
        int count = 0;

        while (i < j && i < n && j >= 0){
            if (people[j] + people[i] <= limit){
                i++;
                j--;
            }
            else
            {
                j--;
            }

            count++;
        }

        if (i == j){
            count++;
        }

        return count;
    }
}
