package leetcode;

public class Problem_63_Unique_Paths_II {
    class Solution {
        public int uniquePathsWithObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] arr = new int[m][n];

            boolean found = false;
            for(int i = 0; i < m; i++) {
                if(found) {
                    arr[i][0] = 0;
                }
                else {
                    if(grid[i][0] == 1) {
                        found = true;
                        arr[i][0] = 0;
                    }
                    else {
                        arr[i][0] = 1;
                    }
                }
            }

            found = false;
            for(int i = 0; i < n; i++) {
                if(found) {
                    arr[0][i] = 0;
                }
                else {
                    if(grid[0][i] == 1) {
                        found = true;
                        arr[0][i] = 0;
                    }
                    else {
                        arr[0][i] = 1;
                    }
                }
            }

            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if(grid[i][j] == 1) {
                        arr[i][j] = 0;
                    }
                    else {
                        arr[i][j] = arr[i-1][j] + arr[i][j-1];
                    }
                }
            }
            return arr[m-1][n-1];
        }
    }
}
