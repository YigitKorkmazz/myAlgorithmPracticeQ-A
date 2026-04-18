package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class JobScheduling {
    /**
     * Given a set of N jobs where each jobi has a deadline and profit associated with it.
     * Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
     * We earn the profit if and only if the job is completed by its deadline.
     * The task is to find the maximum profit and the number of jobs done.
     */

    static class job {
        int deadline;
        int profit;
        job(int d, int p){
            deadline = d;
            profit = p;
        }
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        //we can use greedy approach here
        //sorting the jobs according to their profits and selecting them as late as possible
        int n = deadline.length;
        job[] jobs = new job[n];
        for (int i = 0 ; i < n; i++){
            jobs[i] = new job(deadline[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a,b) -> Integer.compare(b.profit, a.profit));
        int maxD = 0;
        for (int i = 0; i < n; i++){
            maxD = Math.max(maxD, jobs[i].deadline);
        }
        int[] slot = new int[maxD];
        for (int i = 0 ; i < maxD; i++){
            slot[i] = -1; //unvisited
        }
        
        int totalProfit = 0;
        int count = 0;
        for (int i = 0; i < jobs.length; i++){
            for (int j = jobs[i].deadline - 1; j >= 0; j--){
                if (slot[j] == -1){
                    slot[j] = i;
                    totalProfit += jobs[i].profit;
                    count++;
                    break;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(totalProfit);
        
        return res;
    }

    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20,10,40,30};
        System.out.println(jobSequencing(deadline, profit));
    }
}
