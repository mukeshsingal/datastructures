package geeksforgeeks.problems.array.problems;

//Validity of a given Tic-Tac-Toe board configuration
public class Problem15 {
    public static void main(String[] args) {
        char board[] =
                {'O', 'X', ' ',
                'X', ' ', ' ',
                ' ', ' ', ' '};
        if (isValid(board)) {
            System.out.println("Given board is valid");
        } else {
            System.out.println("Given board is not valid");
        }
    }
    static int[][] win= {
            {0, 1, 2}, //first row
            {3, 4, 5}, //second row
            {6, 7, 8}, //third row
            {0, 3, 6}, //first col
            {1, 4, 7}, //second col
            {2, 5, 8}, //third col
            {0, 4, 8}, //first Diagonal
            {2, 4, 6}  //second Diagonal
    };

    public static boolean isValid(char[] board) {
        // validate the count of O and X, board is valid only if Count(O) == Count(X) || Count(O) + 1 == Count(X)
        int xCount = 0, oCount = 0;

        for(char c: board) {
            if(c == 'O') oCount++;
            if(c == 'X') xCount++;
        }
        if(oCount == xCount || oCount+1 == xCount) {
            //check if both win then in that case board is invalid
            if(isWining(board, 'O') && isWining(board, 'X')) {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public static boolean isWining(char[] board, char c) {
        boolean isWin = false;
        boolean isCaseWining = true;
        for(int[] i: win) {
            isCaseWining = true;
            for(int j: i) {
                isCaseWining = isCaseWining && board[j] == c;
            }
            isWin = isWin || isCaseWining;
        }
        return isWin;
    }
}
