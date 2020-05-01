package leetcode;

public class Problm_1254_Number_of_Closed_Islands {

}

class Solution {
    int r = 0;
    int c = 0;
    
    public int closedIsland(int[][] grid) {
        r = grid.length;
        if (r ==0) return 0;
        c = grid[0].length;
        
        int closeFriendsCount = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 0 && DFS(grid, i, j)) {
                    closeFriendsCount++;
                }
            }
        }
        return closeFriendsCount;
        
    }
    
    public boolean DFS(int[][] grid, int i, int j) {
        
        if(i < 0 ||j < 0  ||  i >= r || j >= c) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        
        return DFS(grid, i-1, j) & DFS(grid, i + 1, j) & DFS(grid, i, j-1) & DFS(grid, i, j + 1);
    }
    
}

