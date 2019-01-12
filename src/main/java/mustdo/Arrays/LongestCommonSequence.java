package mustdo.Arrays;

public class LongestCommonSequence {
    public static void main(String[] args) {
        String first = "my name is mukesh";
        String second = "mnaistsh";
        System.out.println("Longest Common Sequence : " +
                getLongestCommonSequence(first.toCharArray(), second.toCharArray(), 0, 0));
        System.out.println("Longest Common Sequence : " +
                getLongestCommonSequence(first.toCharArray(), second.toCharArray()));
    }

    /**
     * Algorithm using plain recursion based on idea
     * if LCS(i, j) =
     * if char[i] == char[j] then
     * LCS will definitely include this and do same for renaming items
     * else
     * then LCS will be max(LCS(i+1, j), LCS(i, j+1))
     */
    public static int getLongestCommonSequence(char[] first, char[] second, int i, int j) {
        if (i == first.length || j == second.length) {
            return 0;
        }
        if (first[i] == second[j]) {
            return 1 + getLongestCommonSequence(first, second, i + 1, j + 1);
        } else {
            return Math.max(
                    getLongestCommonSequence(first, second, i + 1, j),
                    getLongestCommonSequence(first, second, i, j + 1)
            );
        }
    }


    /**
     * Algorithm using Dynamic Programming bottom up approach
     */
    public static int getLongestCommonSequence(char[] first, char[] second) {
        int[][] matrix = new int[first.length + 1][second.length + 1];

        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (first[i - 1] == second[j - 1]) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return matrix[first.length][second.length];
    }
}
