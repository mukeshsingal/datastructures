package leetcode;

public class Problem_463_Island_Perimeter {

    int row = -1;
    int col = -1;

    public int islandPerimeter(int[][] grid) {
        findCell(grid);
        if(row != -1 && col != -1){
            return floodFill(grid, row, col);
        }
        return 0;
    }

    public void findCell(int[][] grid){
        for(int i =0;i < grid.length; i++) {
            for(int j =0; j< grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }

    public int floodFill(int[][] image, int sr, int sc) {
        if(!isValidMove(sr,sc, image)) {
            return 1;
        }

        if(image[sr][sc] == 2) {
            return 0;
        }

        image[sr][sc] = 2;

        return floodFill(image, sr-1, sc) +
                floodFill(image, sr, sc-1) +
                floodFill(image, sr +1, sc) +
                floodFill(image, sr, sc+1);
    }

    boolean isValidMove(int x, int y, int[][] image) {
        if(x < 0 || x >= image.length) {
            return false;
        }
        if(y < 0 || y >= image[0].length) {
            return false;
        }
        if(image[x][y] == 0) {
            return false;
        }
        return true;
    }
}