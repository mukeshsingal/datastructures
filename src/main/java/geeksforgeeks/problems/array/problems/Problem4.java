package geeksforgeeks.problems.array.problems;

/* Largest Sum subarray */
public class Problem4 {
    public static void main(String[] args) {
        int[] array = {1, -8, 1, -2, 3, -2, 2};
        maximumSumSubArray(array);
    }

    /* Kadane's Algorithm */
    public static void maximumSumSubArray(int[] arr) {
        int global_max, current_max;
        global_max = current_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current_max = Math.max(arr[i], current_max + arr[i]);
            if (current_max > global_max) {
                global_max = current_max;
            }
        }
        System.out.println(global_max);
    }
}
