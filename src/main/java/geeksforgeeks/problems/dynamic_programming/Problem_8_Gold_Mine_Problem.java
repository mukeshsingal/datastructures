package geeksforgeeks.problems.dynamic_programming;

import java.util.Arrays;

public class Problem_8_Gold_Mine_Problem {

    public static void main(String[] args) {
        int mat[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
        System.out.println(getMaxGold(mat, 4,4 ));
    }

    public static int gold(int[][] goldMine) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < goldMine.length; i++) {
            max = Math.max(max, gold(goldMine, i, 0));
        }
        return max;
    }

    public static int gold(int[][] goldMine, int i, int j) {

        if (i < 0 || j < 0 || i >= goldMine.length || j >= goldMine[0].length) {
            return 0;
        }
        if (j == goldMine[0].length - 1) {
            return goldMine[i][j];
        }

        int up = gold(goldMine, i + 1, j + 1);
        int down = gold(goldMine, i - 1, j + 1);
        int right = gold(goldMine, i, j + 1);

        return goldMine[i][j] + Math.max(Math.max(up, down), right);
    }

    

    static int getMaxGold(int gold[][], int m, int n) {

        int goldTable[][] = new int[m][n];

        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                int right = (col == n - 1) ? 0 : goldTable[row][col + 1];
                int right_up = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];
                int right_down = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];
                goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));
            }
        }
        
        int res = goldTable[0][0];

        for (int i = 1; i < m; i++)
            res = Math.max(res, goldTable[i][0]);

        return res;
    }
}
