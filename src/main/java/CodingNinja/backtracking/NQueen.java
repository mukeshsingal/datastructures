package CodingNinja.backtracking;

import java.util.Arrays;

public class NQueen {

    static int board[][] = new int[4][4];

    public static void main(String[] args) {
        placeNQueenHelper(4, 0);
    }

    public static void placeNQueenHelper(int n, int row) {
        if (row == n) {
            for (int[] b : board) {
                System.out.println(Arrays.toString(b));
            }
            System.out.println(" ");
            return;
        }
        // place at all possible possitions and move to smaller problem
        for (int j = 0; j < n; j++) {
            if (isPossible(n, row, j)) {
                board[row][j] = 1;
                placeNQueenHelper(n, row + 1);
                board[row][j] = 0;
            }
        }
        return;
    }

    static boolean isPossible(int n, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}