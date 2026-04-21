package greedy;

import java.util.Arrays;

public class TwoCitySchedule {
    /**
     * There are 2N people a company is planning to interview.
     * The cost of flying the i-th person to city A is costs[i][0],
     * and the cost of flying the i-th person to city B is costs[i][1].
     * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
     * Greedy solution in O(n log n)
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int total_cost = 0;
        //sort the costs by the difference between the cost of flying to city A and the cost of flying to city B
        Arrays.sort(costs, (a,b) -> Integer.compare(a[0] - a[1], b[0]- b[1]));
        int n = costs.length;

        for (int i = 0 ; i < n / 2; i++){
            //fly a
            total_cost += costs[i][0];
        }

        for (int i = n / 2; i < n; i++){
            //fly b
            total_cost += costs[i][1];
        }

        return total_cost;
    }
}
