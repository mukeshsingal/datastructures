package geeksforgeeks.problems.dynamic_programming;

public class Problem_6_Permutation_Coefficient {
    static int permutationCoeff(int n, int k) {
        int memo[][] = new int[n + 2][k + 2];

        // Calculate value of Permutation
        // Coefficient in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Base Cases
                if (j == 0)
                    memo[i][j] = 1;

                // Calculate value using previosly
                // stored values
                else
                    memo[i][j] = memo[i - 1][j] + (j * memo[i - 1][j - 1]);

                // This step is important
                // as P(i,j)=0 for j>i
                memo[i][j + 1] = 0;
            }
        }
        return memo[n][k];
    }

    public static void main(String args[]) {
        int n = 10, k = 2;
        System.out.println("Value of P( " + n + "," + k + ")" + " is " + permutationCoeff(n, k));
    }
}