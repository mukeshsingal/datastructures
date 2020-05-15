package CodingNinja.backtracking;

import java.util.Arrays;;

public class Sudoku {
    static final int N = 9;

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0, 0, 4, 0, 9, 0 }, { 8, 0, 2, 9, 7, 0, 0, 0, 0 }, { 9, 0, 1, 2, 0, 0, 3, 0, 0 },
                { 0, 0, 0, 0, 4, 9, 1, 5, 7 }, { 0, 1, 3, 0, 5, 0, 9, 2, 0 }, { 5, 7, 9, 1, 2, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 0, 2, 6, 0, 3 }, { 0, 0, 0, 0, 3, 8, 2, 0, 5 }, { 0, 2, 0, 5, 0, 0, 0, 0, 0 } };

        solve(grid);

        for(int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    static boolean findEmptyLocation(int[][] grid, int[] result) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(grid[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean solve(int[][] grid) {

        int row = -1;
        int col = -1;
        boolean isEmpty = true; 

        for(int i =0; i < 9; i++) {
            for(int j= 0; j < 9; j++) {
                if(grid[i][j] == 0) {
                    row = i; 
                    col = j; 
                    isEmpty = false;  
                    break; 
                }
            }
            if (!isEmpty) { 
                break; 
            }
        }
        if (isEmpty) { 
            return true; 
        } 
        // else for each-row backtrack 
        for (int num = 1; num <= 9; num++) { 
            if (isSafe(grid, row, col, num)) { 
                grid[row][col] = num; 
                if (solve(grid)) { 
                    // print(board, n); 
                    return true; 
                }  
                else{ 
                    grid[row][col] = 0; // replace it 
                }
            }
        }
        return false; 
    }

    static boolean isSafe(int[][] grid, int row, int col, int num) {
        //check in row
        for(int  i = 0; i < 9; i++) {
            if(grid[i][col] == num) {
                return false;
            }
        }

        //check in col

        for(int  i = 0; i < 9; i++) {
            if(grid[row][i] == num) {
                return false;
            }
        }

        int r = row - row%3;
        int c = col - col%3;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[r + i][c + j] == num) {
                    return false;
                }
            }
        }
        return true;

    }

}