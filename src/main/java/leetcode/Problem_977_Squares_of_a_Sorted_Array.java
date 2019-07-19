package leetcode;

public class Problem_977_Squares_of_a_Sorted_Array {

    public int[] sortedSquares(int[] A) {


        if (A == null || A.length == 0) {
            return A;
        }

        int n = A.length;
        int l = 0, r = n - 1;

        int k = n - 1;
        int[] res = new int[n];
        while (l <= r) {
            int n1 = Math.abs(A[l]);
            int n2 = Math.abs(A[r]);

            if (n1 < n2) {
                res[k--] = n2 * n2;
                r--;
            } else {
                res[k--] = n1 * n1;
                l++;
            }
        }
        return res;
    }
}