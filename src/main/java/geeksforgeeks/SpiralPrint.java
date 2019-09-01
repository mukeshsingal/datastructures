package geeksforgeeks;



import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class SpiralPrint {
}


class Solution {

    // Complete the spiralMatrix function below.
    static void spiralMatrix(List<List<Integer>> matrix) {

        int rowCount = matrix.size() - 1;
        int colCount = matrix.get(0).size() -1;
        int row = 0;
        int col = 0;

        int count = matrix.size()/2;

        StringBuilder result = new StringBuilder();
        while(count > 0) {
            for(int i = col; i <= colCount; i++) {
                result.append(matrix.get(row).get(i) + " ");
            }
            row++;

            for (int i = row; i <= rowCount; i++) {
                result.append(matrix.get(i).get(colCount) + " ");
            }
            colCount--;

            for (int i = colCount; i >= col; i--) {
                result.append(matrix.get(rowCount).get(i) + " ");
            }
            rowCount--;

            for (int i = rowCount; i >= row; i--) {
                result.append(matrix.get(i).get(col) + " ");
            }
            col++;

            count--;
        }
        if(matrix.size() % 2 != 0)
            result.append(matrix.get(row).get(col));
        System.out.print(result.toString().trim());
    }
}
