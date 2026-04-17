import java.util.*;

class Solution {

    static class Item {
        int value, weight;

        Item(int v, int w) {
            value = v;
            weight = w;
        }
    }

    static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double res = 0.0;
        int currCap = capacity;

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= currCap) {
                res += items[i].value;
                currCap -= items[i].weight;
            } else {
                res += ((double) items[i].value / items[i].weight) * currCap;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        double result = fractionalKnapsack(val, wt, capacity);
        System.out.println("Maximum value = " + result);
    }
}