package mustdo.Arrays;

import java.util.Arrays;

public class MaximumSumIncreasingSequence {
    public static void main(String[] args) {
        //int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60};
        //int[] arr = {3, 10, 2, 1, 20};
        //int[] arr = {3, 1};
        //int[] arr = {50, 3, 10, 7, 40, 80};
        int[] arr = {1, 101, 2, 3, 100, 4, 5};

        getMaxSumOfIncreasingSubsequence(arr);
    }

    /**
     * Algorithm is based on Dynamic programming approach
     *
     *
     */
    public static void getMaxSumOfIncreasingSubsequence(int[] arr){
        int[] sums = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(sums));
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && sums[i] < sums[j] + arr[i])  {
                    sums[i] = sums[j] + arr[i];
                    if(sums[i] > maxLength) {
                        maxLength = sums[i];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(sums));
        System.out.println("Max Sum of increasing subsequence" + maxLength);
    }
}
