package algo.dp;

public class LongestIncreasingSubsequnce {

    /**
     * O(N2) solution for LIS
     */
    public static int lis(int[] arr, int n) {
        if (n <= 0)
            return 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int len = 1;
            for (int j = i + 1; j < n; j++) {
                if (temp < arr[j]) {
                    len++;
                    temp = arr[j];
                }
            }
            if (len > maxLength) {
                maxLength = len;
            }
        }
        return maxLength;
    }


    public static int lis2(int[] arr, int n) {
        if(n == arr.length-1) {
            return 0;
        }

        if(arr[n] < arr[n+1]) {
            return 1 + lis2(arr, n+1);
        }
        else {
            return lis2(arr, n+1);
        }
    }



    public static void main(String args[]) {
        int arr[] =   {89, 50, 3, 10, 2, 11, 80};
        int n = arr.length;
        System.out.println("Length of lis is " + (lis(arr, arr.length)));
    }
}
