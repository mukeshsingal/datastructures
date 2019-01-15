package mustdo.BackTracking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int[][] chessBoard = new int[4][4];

        for (int[] arr : chessBoard) {
            Arrays.fill(arr, 0);
        }

        NQueen n = new NQueen();

        if (n.nQueenProblem(chessBoard, 0)) {
            for (int[] arr : chessBoard) {
                System.out.println(Arrays.toString(arr));
            }
        } else {
            System.out.println("Soltion doesn't exist");
        }
    }

    public boolean nQueenProblem(int[][] chessBoard, int col) {
        if (col >= chessBoard.length)
            return true;

        for (int i = 0; i < chessBoard.length; i++) {
            if (isSafe(chessBoard, i, col)) {
                chessBoard[i][col] = 1;

                if (nQueenProblem(chessBoard, col + 1))
                    return true;

                chessBoard[i][col] = 0; // BACKTRACK 
            }
        }
        return false;
    }

    public boolean isSafe(int[][] chessBoard, int xIndex, int yIndex) {
        //if Queen is in same row
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[xIndex][i] == 1) {
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (int i = xIndex, j = yIndex; i >= 0 && j >= 0; i--, j--)
            if (chessBoard[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (int i = xIndex, j = yIndex; j >= 0 && i < chessBoard.length; i++, j--)
            if (chessBoard[i][j] == 1)
                return false;

        return true;
    }
}
