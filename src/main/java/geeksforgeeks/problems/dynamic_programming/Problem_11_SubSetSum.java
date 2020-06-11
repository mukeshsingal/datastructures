package geeksforgeeks.problems.dynamic_programming;

public class Problem_11_SubSetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 30;

        System.out.println(subsetSum(arr, 0, sum));
    }

    public static boolean subsetSum(int[] arr, int index, int sum) {
        if(sum == 0) {
            return true;
        }
        if(sum < 0) {
            return false;
        }

        if(index == arr.length) {
            return false;
        }

        return subsetSum(arr, index+1, sum - arr[index]) || subsetSum(arr, index+1, sum);
    }

    /**TODO: Compete Bottom up for this problem */
    public static boolean bottomUp(int[] arr) {
        return true;
    }
}