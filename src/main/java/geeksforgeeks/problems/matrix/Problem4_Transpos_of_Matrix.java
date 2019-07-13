package geeksforgeeks.problems.matrix;

import java.util.Arrays;

public class Problem4_Transpos_of_Matrix {
    public static void main(String[] args) {
        int[][] A = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48,},
                {32, 33, 39, 50}};
        transpose(A, 4);
    }

    private static void transpose(int[][] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        for (int[] arr : A) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
