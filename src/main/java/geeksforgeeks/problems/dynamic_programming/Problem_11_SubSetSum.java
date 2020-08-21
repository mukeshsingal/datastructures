package geeksforgeeks.problems.dynamic_programming;

public class Problem_11_SubSetSum {
    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        System.out.println(subsetSum(arr, 0, sum));

        System.out.println(isSubsetExists(arr, sum));
    }

    public static boolean subsetSum(int[] arr, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }

        if (index == arr.length) {
            return false;
        }

        return subsetSum(arr, index + 1, sum - arr[index]) || subsetSum(arr, index + 1, sum);
    }

    public static boolean isSubsetExists(int[] arr, int sum) {
        if (arr.length == 0) {
            return false;
        }

        boolean[][] mat = new boolean[arr.length][sum + 1];

        for (int i = 0; i < arr.length; i++) {
            mat[i][0] = true;
        }

        for (int j = 0; j <= sum; j++) {
            if (j == arr[0]) {
                mat[0][j] = true;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (mat[i - 1][j]) {
                    mat[i][j] = true;
                } else {
                    if (j >= arr[i]) {
                        mat[i][j] = mat[i - 1][j - arr[i]];
                    }
                }
            }
        }

        return mat[arr.length - 1][sum];
    }

}