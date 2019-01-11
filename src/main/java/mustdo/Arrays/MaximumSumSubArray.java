package mustdo.Arrays;

/**
 * Kadane's Algorithm
 * ---------------------------
 * Use two int variables maxSoFar and maxEndingHere
 * - To tract of maximum sum, keep track of positive number using maxEndingHere
 * - when maxEndingHere < 0 then maxEndingHer = 0
 * - when maxEndingHere > maxSoFar then maxSoFar = maxEndingHere
 */
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -3, -2, -4, -3, -5};
        System.out.println("Maximum sum is : " + getMaximumSumSubArray(arr));
        System.out.println("Maximum sum is : " + getMaximumSumSubArray2(arr));
    }

    public static int getMaximumSumSubArray(int[] arr) {
        int maxSoFar = 0, maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere < 0)
                maxEndingHere = 0;
            else if (maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }

    //Kadane's Algorithm with negative case
    public static int getMaximumSumSubArray2(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], arr[i] + maxEndingHere);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
