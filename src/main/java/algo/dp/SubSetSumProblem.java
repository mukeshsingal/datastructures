package algo.dp;


import java.util.Arrays;

public class SubSetSumProblem {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 34, 4, 5, 12, 2, 0};

        int successCase1  = 2;
        int failedCase1  = 30;

        boolean case1 = isSubsetExist(arr, successCase1);
        boolean case2 = isSubsetExist(arr, failedCase1);

        System.out.println("Case 1 sum " + successCase1 + " => output : " + case1);
        System.out.println("Case 2 sum " + failedCase1 + " => output : " + case2);
    }

    public static boolean isSubsetExist(int[] array, int sum) {
        System.out.println(Arrays.toString(array));
        //return isSubsetExistRec(array, sum, 0);

//        int[] memo = new int[array.length];
//        return isSubsetExistMemo(array, sum, 0, memo);

        return isSubsetExistBottomUp(array, sum);
    }

    private static boolean isSubsetExistRec(int[] array, int sum, int index) {
        if(index == array.length) {
            return sum == 0;
        }

        if(sum < 0) {
            return false;
        }

        if(sum == 0) {
            return true;
        }

        return isSubsetExistRec(array, sum - array[index], index + 1) || isSubsetExistRec(array, sum, index + 1);
    }

    /**
     * Since the output is boolean, there is not way to tell from boolean array if we cached the result of not.
     * We need a default value which could represent empty value. We can use int array instead.
     *
     * 0 (default) -> Haven't calculated yet. Calculate now.
     * 1 -> calculated and true
     * 2 -> calculated and false
     */
    private static boolean isSubsetExistMemo(int[] arr, int sum, int index, int[] memo) {
        if (index == arr.length) {
            return sum == 0;
        }

        if(sum < 0) {
            return false;
        }
        if(sum == 0) {
            return true;
        }

        if(memo[index] != 0) {
            return memo[index] == 1;
        }

        boolean output = isSubsetExistMemo(arr, sum - arr[index], index + 1, memo) || isSubsetExistMemo(arr, sum, index + 1, memo);

        memo[index] = output ? 1 : 2;

        return  output;
    }

    /**
     * In Bottom Up we need have a cache table. Its size depends of Array Length and Sum.
     * Array size (n) (v) -> vertical
     * Sum (m) -> horizontal
     */
    public static boolean isSubsetExistBottomUp(int arr[], int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum+1];


        for(int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        /* Below initialization is not required as by default values are false in boolean array
            for(int j = 1; j <= sum; j++) {
                dp[0][j] = false;
            }
        */
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                /* exclude then sum should be result of from remaining elements
                    dp[i][j] = dp[i-1][j];
                 */
                /*
                    include  then find  solution for subproblem
                    remaining sum needed -> j - arr[i]
                    dp[i][j] = dp[i-1][j-arr[i]];
                */

                if(j - arr[i-1] < 0) { //means number is more than required sum then we cannot include it
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }

                //
            }
        }



        return dp[arr.length][sum];



//        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
//        for (int i = 0; i <= arr.length; i++) {
//            dp[i][0] = true;
//        }
//
//        for (int i = 1; i <= arr.length; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (j - arr[i - 1] >= 0) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[arr.length][sum];

    }
}
