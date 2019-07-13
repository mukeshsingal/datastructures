package geeksforgeeks.problems.matrix;


//https://www.geeksforgeeks.org/count-zeros-in-a-row-wise-and-column-wise-sorted-matrix/

public class Problem1_Count_zeros_in_a_row_wise_and_column_wise_sorted_matrix {

    int countZeros(int A[][], int n){
        int currentRow = n - 1;
        int currentCol = 0;

        int zeroCount = 0;

        while(currentRow >= 0 && currentCol != n) {
            if(A[currentRow][currentCol] == 1) {
                currentRow--;
            }
            else {
                zeroCount += currentRow + 1;
                currentCol += 1;
            }
        }
        return zeroCount;
    }
}


