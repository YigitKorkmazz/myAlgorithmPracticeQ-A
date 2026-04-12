package greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    /**
     * Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
     * Return the maximum value as a double, rounded to 6 decimal places.
     */
    static class Item {
        int value, weight;
        double ratio;

        Item(int v, int w) {
            value = v;
            weight = w;
            ratio = (double) v / w;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }
        
        // any O(n log n) sorting algorithm can be used here
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (capacity >= items[i].weight) {
                maxValue += items[i].value;
                capacity -= items[i].weight;
            } else {
                maxValue += items[i].ratio * capacity;
                break;
            }
        }

        return maxValue;
    }
}
