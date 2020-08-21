package leetcode;

public class Problem_1267_Count_Servers_that_Communicate {

    public int countServers(int[][] grid) {
        int count = 0;
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            int serverCount = 0; 
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}