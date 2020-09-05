package algo.dp;

import sun.awt.image.IntegerComponentRaster;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDifferencePartition {

    public static void main(String[] args) {

        int[] arr = new int[] { 8, 5, 5, 11};

        System.out.println("Abs difference for " + Arrays.toString(arr) + " is " + absDiffernce(arr));

    }

    /**
     * Now we know what is the range of ans. We know answer will like between 0, 23.
     * Answer will be the minimum difference of sum of each partition. Lets say
     * s1 -> sum of first partition
     * s2 -> sum of second partition
     *
     * Since we know that total sum has to be 23 for partition. We can say
     * s2 = T - s1
     *
     * We want to calculate Minimum Abs(s2 - s1)
     *
     * Answer = s2 - s1
     * Answer = (T - s1) - s1
     * Answer = T - (2 * s1)
     *
     * Now all we have to do is that we need to find minimum answer.
     *
     * Solution 1:
     * Part: Getting possible values for s1 which could result in answer.
     *
     * Now we also know that T = 23 and absolute difference between partition will be the least.
     * We can conclude that s1 will be 0 <= s1 <= T/2
     *
     *
     * We reduced problem to great extent but still we need to find a way to check all the values  0 <= s1 <= T/2
     * where there is any partition exist with sum = given value between 0 <= s1 <= T/2
     *
     * Subset sum can helps in that. Last row in subset sum represent that With Full array given sum (j) exist or not.
     *
     * Now can calculate all the possible value of Answer and find minimum of those. That will be our final answer.
     */

    public  static int absDiffernce(int[] arr) {
        int sum = 0; // Total Sum of Array

        for(int i : arr) sum+=i;

        boolean[][] dp = new boolean[arr.length + 1][sum+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if(arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i <= sum/2; i++) {
            if(dp[arr.length][i]) {
                minimum = Math.min(minimum, sum - 2*i);
            }
        }

        return minimum;

    }



}
