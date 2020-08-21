package leetcode;

public class Problem_200_Number_of_Islands {

    int r = 0;
    int c = 0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        r = grid.length;
        c = grid[0].length;
        
        int count = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    
    public void DFS(char[][] grid, int r, int c) {
        if(isValid(r, c, grid)) {
            grid[r][c] = 'x';
            DFS(grid, r + 1, c);
            DFS(grid, r - 1, c);
            DFS(grid, r, c + 1);
            DFS(grid, r, c - 1);
        }
    }
    public boolean isValid(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= r || j >= c) return false;
        if (grid[i][j] == 'x' || grid[i][j] == '0') return false;
        return true;
    }
}
