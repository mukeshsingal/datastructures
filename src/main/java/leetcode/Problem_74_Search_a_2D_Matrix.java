package leetcode;

public class Problem_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length > 0) {
            return searchMatrix(matrix, 0, (matrix[0].length * matrix.length - 1), target);
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int rowLength = matrix[0].length;
        int mid = start + ((end - start) / 2);
        int colMid = mid % rowLength;
        int rowMid = mid / rowLength;

        if (matrix[rowMid][colMid] == target) {
            return true;
        }
        if (target < matrix[rowMid][colMid]) {
            return searchMatrix(matrix, start, mid - 1, target);
        } else {
            return searchMatrix(matrix, mid + 1, end, target);
        }
    }
}
