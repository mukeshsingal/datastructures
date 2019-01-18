package mustdo.DP;

import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        //           0  1  2  3  4  5  6  7  8  9
        int[] arr = {2, 2, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(minimumJumps(arr, 0, 0));
        System.out.println(jumps(arr));
    }

    public static int minimumJumps(int[] arr, int i, int count) {
        if (i + 1 >= arr.length) {
            return count;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i]; j++) {
            min = Math.min(min, minimumJumps(arr, i + j, count + 1));
        }
        return min;
    }

    public static int jumps(int[] arr) {
        int[] noOfJumps = new int[arr.length];
        Arrays.fill(noOfJumps, Integer.MAX_VALUE);

        noOfJumps[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    noOfJumps[i] = Math.min(noOfJumps[j] + 1, noOfJumps[i]);
                }
            }

        }
        return noOfJumps[noOfJumps.length-1];
    }
}
