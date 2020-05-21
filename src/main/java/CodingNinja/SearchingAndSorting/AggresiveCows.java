package CodingNinja.SearchingAndSorting;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        cows(new int[] {1, 2, 8, 4, 9}, 3);
    }

    public static void cows(int[] array, int cowsCount) {

        Arrays.sort(array);

        int start = array[0];
        int end = array[array.length - 1] - start;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(cowsCount, array, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean check(int cowsCount, int[] array, int distance) {
        int count = 1;
        int lastPosition = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] - lastPosition >= distance) {
                lastPosition = array[i];
                count++;
            }
            if (count == cowsCount) {
                return true;
            }
        }
        return false;
    }

}