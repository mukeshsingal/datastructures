package geeksforgeeks.problems.matrix;

public class Problem5_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int size = board.length;

        //Check row and col
        for(int i = 0; i < size; i++) {
            if(!checkDuplicates(board, i, i, 0, board.length-1) || !checkDuplicates(board, 0, board.length-1, i, i)){
                return false;
            }
        }
        //Check block
        for(int i = 0; i < size; i = i + 3) {
            for(int j = 0; j < size; j = j + 3) {
                if(!checkDuplicates(board, i, i + 2, j, j + 2)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkDuplicates(char[][] board, int sr, int er, int sc, int ec) {
        int[] arr = new int[board.length +1];
        for(int  i = sr; i <= er; i++) {
            for(int  j = sc; j <= ec; j++) {
                if(board[i][j] != '.') {
                    if(arr[board[i][j] - '0'] == 1) {
                        return false;
                    }
                    arr[board[i][j] - '0'] = 1;
                }
            }
        }
        return true;
    }
}
