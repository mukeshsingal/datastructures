package mustdo.Arrays;

import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        zigzag(arr);
    }

    private static void zigzag(int[] arr) {
        System.out.println("Initial Array : " + Arrays.toString(arr));

        boolean flag = true; // mean < is expected

        for (int i = 0; i < arr.length - 2; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            } else {
                if (arr[i] < arr[i + 1])
                    swap(arr, i, i + 1);
            }
            flag = !flag;
        }
        System.out.println("Modified Array : " + Arrays.toString(arr));
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
