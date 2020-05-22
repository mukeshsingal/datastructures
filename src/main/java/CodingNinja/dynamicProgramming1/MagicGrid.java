package CodingNinja.DynamicProgramming1;

import java.util.Scanner;
import java.util.Arrays;

public class MagicGrid {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCaseCount = s.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int[][] matrix = init(s);

            int r = matrix.length;
            int c = matrix[0].length;

            if (r == 1 && c == 1) {
                System.out.println(matrix[0][0] + 1);
            } else {
                int[][] dp = new int[r][c];

                dp[r - 1][c - 1] = matrix[r - 1][c - 1] + 1;

                // fill the last row
                for (int j = c - 2; j >= 0; j--) {
                    if (dp[r - 1][j + 1] - matrix[r - 1][j] <= 0) {
                        dp[r - 1][j] = 1;
                    } else {
                        dp[r - 1][j] = dp[r - 1][j + 1] - matrix[r - 1][j];
                    }
                }

                // fill the last col
                for (int j = r - 2; j >= 0; j--) {
                    if (dp[j + 1][c - 1] - matrix[j][c - 1] <= 0) {
                        dp[j][c - 1] = 1;
                    } else {
                        dp[j][c - 1] = dp[j + 1][c - 1] - matrix[j][c - 1];
                    }
                }

                for (int j = r - 2; j >= 0; j--) {
                    for (int k = c - 2; k >= 0; k--) {
                        dp[j][k] = Math.min(dp[j + 1][k], dp[j][k + 1]) - matrix[j][k];
                        if (dp[j][k] <= 0) {
                            dp[j][k] = 1;
                        }
                    }
                }

                System.out.println(dp[0][0]);
            }
        }
    }

    public static int[][] init(Scanner s) {
        int rowCount = s.nextInt();
        int colCount = s.nextInt();

        int[][] matrix = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}