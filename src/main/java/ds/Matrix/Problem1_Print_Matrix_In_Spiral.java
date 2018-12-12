package ds.Matrix;

public class Problem1_Print_Matrix_In_Spiral {
    public static void main(String[] args) {
        int m = 3;
        int n = 6;
        int arr[][] = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(m, n, arr);
    }

    private static void spiralPrint(int rowSize, int colSize, int[][] arr) {
        int i, rowIndex = 0, colIndex = 0;

        while (rowIndex < rowSize && colIndex < colSize) {

            /* Print the first row of remaining rows */
            for (i = colIndex; i < colSize; i++) {
                System.out.println(arr[rowIndex][i]);
            }
            rowIndex++;

            /* Last col of remaining columns */
            for (i = rowIndex; i < rowSize; i++) {
                System.out.println(arr[i][colSize - 1]);
            }
            colSize--;

            //print last row
            if (rowIndex < rowSize) {
                for (i = colSize - 1; i >= colIndex; i--) {
                    System.out.println(arr[rowSize - 1][i]);
                }
                rowSize--;
            }

            if (colIndex < colSize) {
                for (i = rowSize - 1; i >= rowIndex; --i) {
                    System.out.print(arr[i][colIndex] + " ");
                }
                colIndex++;
            }
        }
    }
}
