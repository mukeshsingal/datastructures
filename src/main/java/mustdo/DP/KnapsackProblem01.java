package mustdo.DP;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent
 * values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset
 * is smaller than or equal to W.
 */
public class KnapsackProblem01 {
    public static void main(String[] args) {
        int profits[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int totalKnapsackCapacity = 50;
        System.out.println(recursiveKnapsack(totalKnapsackCapacity, weights, profits, weights.length));
    }

    /**
     * 1. Either item is included in the set
     * 2. not included in the optimal set
     * <p>
     * Thus maximum value can be obtained by
     * max(
     * 1. n-1 with W weight (excluding current)
     * 2. Value of nth item + value of (n-1 with W weight-weight of nth item)
     */
    public static int recursiveKnapsack(int capacityLeft, int[] weights, int[] profits, int itemIndex) {
        //Base Case
        if (itemIndex == 0 || capacityLeft == 0) {
            return 0;
        }

        if (weights[itemIndex - 1] > capacityLeft) {
            return recursiveKnapsack(capacityLeft, weights, profits, itemIndex - 1);
        } else {
            return Math.max(profits[itemIndex - 1] + recursiveKnapsack(capacityLeft - weights[itemIndex - 1], weights, profits, itemIndex - 1),
                    recursiveKnapsack(capacityLeft, weights, profits, itemIndex - 1));
        }
    }

}
