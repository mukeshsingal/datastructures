package algo.dp;

import java.util.Arrays;
import java.util.Collections;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] successCase1 = new int[] {1, 5 , 11, 7};
        int[] failureCase1 = new int[] {2, 9 , 11, 2};

        boolean case1 = isEqualSumSubsetExist(successCase1);
        boolean case2 = isEqualSumSubsetExist(failureCase1);

        System.out.println("Case 1 sum " + Arrays.toString(successCase1) + " => output : " + case1);
        System.out.println("Case 2 sum " + Arrays.toString(failureCase1) + " => output : " + case2);
    }

    public static boolean isEqualSumSubsetExist(int[] arr) {
        int totalSum = 0;

        for (int i:  arr) totalSum+=i;

        if(totalSum % 2 != 0) {
            return  false;
        }

        return equalSumSubsetHelper(arr, totalSum/2);
    }

    /**
     * Now problem is reduced to subset sum problem. Which we can solve using bottom up
     *
     */
    private static boolean equalSumSubsetHelper(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length+1][sum+1];

        // if sum required is 0 and we have any number of elements, we can get the required sum
        for (int i = 0; i < arr.length; i++) {
           dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if(j - arr[i-1] < 0) { //we need to exlude it
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }


            }
        }

        return dp[arr.length][sum];

    }
}
