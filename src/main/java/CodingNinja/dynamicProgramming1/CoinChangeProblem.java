package CodingNinja.dynamicProgramming1;

import java.util.Arrays;

public class CoinChangeProblem {

    public static int countWaysToMakeChange(int[] denominations, int value) {
        int[][] matrix = new int[value + 1][denominations.length];
        for (int[] a : matrix) {
            Arrays.fill(a, -1);
        }

        return ways(denominations, value, 0, matrix);
    }

    public static int ways(int[] denominations, int value, int dCount, int[][] memo) {
        if (value == 0) {
            return 1;
        }
        if (value < 0) {
            return 0;
        }
        if (dCount == denominations.length) {
            return 0;
        }
        if (memo[value][dCount] > -1) {
            return memo[value][dCount];
        }

        int first = ways(denominations, value - denominations[dCount], dCount, memo);
        int second = ways(denominations, value, dCount + 1, memo);

        memo[value][dCount] = first + second;
        return first + second;
    }
}
