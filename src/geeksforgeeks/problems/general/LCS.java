package geeksforgeeks.problems.general;

public class LCS {
    static String s1 = "BDE";
    static String s2 = "ABCDSE";

    static int[][] memo = new int[s1.length() + 1][s2.length() + 1];
    static int[][] memo2 = new int[s1.length()][s2.length()];


    public static void main(String[] args) {
        System.out.println(lcsUsingDP(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1));
    }
    
    //(Bottom up approach: using DP)
    public static int lcsUsingDP(char[] s1, char[] s2, int l1, int l2) {
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    System.out.print(s1[i-1]);
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[l1][l2];
    }

    /*(To Down approach) - LCS with Memoization which convert its time complexity from 2 exponential to m X n where m and n are length of strings * */
    public static int lcs(char[] s1, char[] s2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (memo2[i][j] != 0) {
            return memo2[i][j];
        }
        if (s1[i] == s2[j]) {
            memo2[i][j] = 1 + lcs(s1, s2, i - 1, j - 1);
            System.out.print(s1[i]);
            return memo2[i][j];
        } else {
            return memo2[i][j] = Math.max(lcs(s1, s2, i - 1, j), lcs(s1, s2, i, j - 1));
        }
    }
}
