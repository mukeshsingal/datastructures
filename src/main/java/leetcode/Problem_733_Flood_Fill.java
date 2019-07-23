package leetcode;

public class Problem_733_Flood_Fill {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    public void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(!isValidMove(sr,sc, image, newColor, oldColor)) {
            return;
        }

        image[sr][sc] = newColor;

        floodFill(image, sr -1, sc, newColor, oldColor);
        floodFill(image, sr, sc-1, newColor, oldColor);
        floodFill(image, sr +1, sc, newColor, oldColor);
        floodFill(image, sr, sc+1, newColor, oldColor);
    }

    boolean isValidMove(int x, int y, int[][] image, int newColor, int oldColor) {
        if(x < 0 || x >= image.length) {
            return false;
        }
        if(y < 0 || y >= image[0].length) {
            return false;
        }
        if(image[x][y] == newColor) {
            return false;
        }
        if(image[x][y] != oldColor) {
            return false;
        }
        return true;
    }
}

