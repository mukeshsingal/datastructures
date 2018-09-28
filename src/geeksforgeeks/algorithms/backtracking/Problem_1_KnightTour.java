package geeksforgeeks.algorithms.backtracking;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The knight is placed on the first block of an empty board and,
 * moving according to the rules of chess, must visit each square
 * exactly once chessboard with 8 x 8 cells..
 *
 *  URL: https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
 */
public class Problem_1_KnightTour {
    public static final int size = 8;

    /**
     * This function solves the Knight Tour problem using Backtracking.
     * This function mainly uses solveKTUtil() to solve the problem. It
     * returns false if no complete tour is possible, otherwise return true
     * and prints the tour. Please note that there may be more than one
     * solutions, this function prints one of the feasible solutions.
     */
    private static boolean solveKT(){
        int[][] sol = new int[size][size];

        /* Initialize the solution Matrix */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sol[i][j] = -1;
            }
        }

        /*
         * xMove[] and yMove[] define next move of Knight.
         * xMove[] is for next value of x coordinate yMove[]
         * is for next value of y coordinate
         */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using solveKTUtil() */

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSol(sol);

        return true;
    }

    /* A recursive utility function to solve Knight Tour problem */
    private static boolean solveKTUtil(
            int x, int y,
            int movei, int[][] sol,
            int[] xMove, int[] yMove) {

        int k, next_x, next_y;
        if (movei == size * size)
            return true;

        /* Try all next moves from the current coordinate x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtracking
            }
        }

        return false;
    }
    /* A utility function to check if i,j are valid indexes for size*size chessboard */
    private static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < size && y >= 0 && y < size && sol[x][y] == -1);
    }

    private static void printSol(int[][] sol) {
        /* Initialize the solution Matrix */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sol[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKT();
    }
}
