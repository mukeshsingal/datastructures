package geeksforgeeks.problems.dynamic_programming;

public class Problem_5_Bionomial_Coefficent {
    public static void main(String[] args) {
        System.out.println("bionomialCoefficient" + bionomialCoefficient(10, 3));
        System.out.println("bionomialCoefficient" + bionomialCoefficientMemo(10, 3, new int[11][4]));
        System.out.println("bionomialCoefficient" + bottomUp(4, 2));
    }   
    
    public static int bionomialCoefficient(int n, int k) {
        if(n == k || k == 0) {
            return 1;
        }

        return bionomialCoefficient(n-1, k-1) + bionomialCoefficient(n-1, k);

    }

    public static int bionomialCoefficientMemo(int n, int k, int[][] memo) {
        if(n == k || k == 0) {
            return 1;
        }
        if(memo[n][k] != 0) {
            return memo[n][k];
        }
        memo[n][k] = bionomialCoefficientMemo(n-1, k-1, memo) + bionomialCoefficientMemo(n-1, k, memo);
        return memo[n][k];

    }

    public static int bottomUp (int n , int k) {
        int[][] memo = new int[n+1][k+1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                
                if(i == 0 || i==j || j == 0) {
                    memo[i][j] = 1;
                }
                else {
                    memo[i][j] = memo[i-1][j] + memo[i-1][j-1];
                }
            }
        }
        return memo[n][k];

    }
}