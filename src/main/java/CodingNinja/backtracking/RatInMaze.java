package CodingNinja.Backtracking;

import java.util.Arrays;

public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 1}, {1,1,1}};
        ratInMaze(maze, 3);
    }
    
    static void  ratInMaze(int[][] maze, int n) {
        int[][] solution = new int[n][n];

        ratInMazeHelper(maze, n, 0, 0, solution);
    }

    static void ratInMazeHelper(int[][] maze, int n, int row, int col, int[][] solution) {

        //System.out.println(row + " " +col);

        if (row >= n || col >= n || row < 0 || col < 0 || maze[row][col] == 0 || solution[row][col] == 1) {
            return;
        }
        if (row == n - 1 && col == n - 1) {
            solution[row][col] = 1;
            for (int[] s : solution) {
                System.out.println(Arrays.toString(s));
            }
            System.out.println(" ");
            solution[row][col] = 0;
            return;
        }
        solution[row][col] = 1;
        ratInMazeHelper(maze, n, row - 1, col, solution);
        ratInMazeHelper(maze, n, row + 1, col, solution);
        ratInMazeHelper(maze, n, row, col - 1, solution);
        ratInMazeHelper(maze, n, row, col + 1, solution);
        solution[row][col] = 0;
    }
}
