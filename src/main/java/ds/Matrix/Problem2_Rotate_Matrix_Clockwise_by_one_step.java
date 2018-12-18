package ds.Matrix;

public class Problem2_Rotate_Matrix_Clockwise_by_one_step {
    static int m = 4;
    static int n = 4;

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("Output");

        int result[][] = RotateMatrix(m, n, matrix);

        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Algorithm says start with outermost ring and do the following
     * 1. Move element of upper row
     * 2. Move element of last column
     * 3. Move element of bottom row
     * 4. Move element of first column
     */
    public static int[][] RotateMatrix(int m, int n, int[][] matrix) {
        int row = 0, col = 0, prev, current;
        int i;

        /**
         * row : starting of the row
         * col : starting of col
         * m : end of row
         * n : end of column
         * i        : iterator
         */

        //Move top elements
        while (row < m && col < n) {

            //Move elements of first row
            prev = matrix[row + 1][col];
            for (i = col; i < n; i++) {
                current = matrix[row][i];
                matrix[row][i] = prev;
                prev = current;
            }
            row++;

            //Move elements of last col
            for (i = row; i < m; i++) {
                current = matrix[i][n - 1];
                matrix[i][n - 1] = prev;
                prev = current;
            }
            n--;

            //last row
            if (row < m) {
                for (i = n - 1; i >= col; i--) {
                    current = matrix[m - 1][i];
                    matrix[m - 1][i] = prev;
                    prev = current;
                }
                m--;
            }

            //last row
            if (col < n) {
                for (i = m - 1; i >= row; i--) {
                    current = matrix[i][col];
                    matrix[i][col] = prev;
                    prev = current;
                }
                col++;
            }
        }

        return matrix;
    }
}
