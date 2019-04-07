package CodingNinja.BitMasking;

import java.util.Arrays;

/**
 * One job can also be assigned to one person, one person can do only one job
 * We need minimize the cost to complete all the jobs.
 */
public class AssignNJobsToNPeople {
    public static void main(String[] args) {
        int[][] cost = {{10, 2, 6, 5}, {1, 15, 12, 8}, {7, 8, 9, 3}, {15, 13, 4, 10}};

        int[] dp = new int[1 << 4];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = minCost(cost, 4, 0, 0, dp);
        System.out.println(ans);
    }

    private static int minCost(int[][] cost, int P, int J, int mask, int[] dp) {
        if (J >= P) {
            return 0;
        }
        if (dp[mask] != Integer.MAX_VALUE) {
            return dp[mask];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < P; i++) {
            if ((mask & (1 << i)) == 0) {
                int ans = minCost(cost, P, J + 1, (mask | (1 << i)), dp) + cost[J][i];
                if (min > ans) {
                    min = ans;
                }
            }
        }
        dp[mask] = min;
        return min;
    }
}


