package greedy;

public class PoliceThieves {
    /**
     * Given an array of characters where each character is either 'P' (representing a police officer) or 'T' (representing a thief).
     * Each police officer can catch a thief if the thief is within K units of distance from the police officer.
     * The task is to find the maximum number of thieves that can be caught
     * O(n) time complexity and O(n) space complexity GREEDY solution.
     * TWO POINTERS APPROACH
     */
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int[] policeIndexes= new int[n];
        int[] thiefIndexes = new int[n];
        
        int t = 0;
        int p = 0;
        for (int m = 0 ; m < n; m++){
            if (arr[m] == 'T'){
                thiefIndexes[t] = m;
                t++;
            }
            else
            {
                policeIndexes[p] = m;
                p++;
            }
        }
        
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < p && j < t){
            if (Math.abs(policeIndexes[i] - thiefIndexes[j]) <= k){
                count++;
                i++;
                j++;
            }
            else if (policeIndexes[i] < thiefIndexes[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        
        
        return count;
        
    }
}
