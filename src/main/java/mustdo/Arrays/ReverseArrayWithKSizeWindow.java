package mustdo.Arrays;

import java.util.Arrays;

public class ReverseArrayWithKSizeWindow {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {50, 3, 10, 7, 40, 80};
        reverse(arr, k);
    }

    public static void reverse(int[] arr, int k) {

        int i = 0;
        int windowStart;
        int windowEnd;
        while (i + k < arr.length) {
            windowStart = i;
            windowEnd = windowStart + k - 1;
            reverse(arr, windowStart, windowEnd);
            i += k;
        }
        reverse(arr, arr.length - (arr.length % k), arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int x, int y) {
        while (x < y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }


}
