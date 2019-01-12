package mustdo.Arrays;

import java.util.Arrays;

public class ChocokletDistribution {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};

        int m = 7;

        int n = arr.length;
        System.out.println("Minimum difference is " + findMinDiff(arr, n, m));

    }

    private static int findMinDiff(int[] arr, int n, int m) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int first = 0, last = 0;
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
                first = i;
                last = i + m - 1;
            }
        }
        return (arr[last] - arr[first]);
    }
}
