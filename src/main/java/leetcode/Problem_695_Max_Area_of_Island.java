package leetcode;

public class Problem_695_Max_Area_of_Island {


    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int max = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, DFS(grid, i, j));
                }
            }
        }
        return max;
    }
    
    public int DFS(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        
        return 1 + DFS(grid, i + 1, j) + DFS(grid, i - 1, j) + DFS(grid, i, j - 1) + DFS(grid, i, j + 1);
    }
}