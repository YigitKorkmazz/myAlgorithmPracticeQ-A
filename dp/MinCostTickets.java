package dp;

public class MinCostTickets {
    /**
     * In a country popular for train travel,
     * you have planned some train travelling one year in advance.
     * The days of the year in which you will travel are given as an array days.
     * Each day is an integer from 1 to 365.
     * Train tickets are sold in 3 different ways:
     * a 1-day pass is sold for costs[0] dollars;
     * a 7-day pass is sold for costs[1] dollars;
     * a 30-day pass is sold for costs[2] dollars.
     * The passes allow that many days of consecutive travel.
     * T(n) = O(maxDay), where maxDay is the last day of travel in the input array.
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];

        boolean[] travel = new boolean[lastDay + 1];
        for (int day : days) {
            travel[day] = true;
        }

        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {

            if (!travel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int oneDay = dp[i - 1] + costs[0];
            int sevenDay = dp[Math.max(0, i - 7)] + costs[1];
            int thirtyDay = dp[Math.max(0, i - 30)] + costs[2];

            dp[i] = Math.min(oneDay,
                    Math.min(sevenDay, thirtyDay));
        }

        return dp[lastDay];
    }
}
