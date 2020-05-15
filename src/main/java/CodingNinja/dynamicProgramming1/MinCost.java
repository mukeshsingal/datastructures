package CodingNinja.dynamicProgramming1;

import java.util.Arrays;

class MinCost {

    public static void main(String[] args) {
        int[][] matrix = {{4, 3, 2}, {1, 8, 3}, { 1, 1, 8}};
        System.out.println("Recursion : " + minCost(matrix, 0, 0, 2, 2));

        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        System.out.println("With memo : " + minCostMemo(matrix, 0, 0, 2, 2, memo));

        System.out.println("Iterative : " + minCostIterative(matrix, 3,3));



    }

    public static int minCost (int[][] matrix, int si, int sj, int ei, int ej) {

        if(si == ei && sj == ej) {
            return matrix[si][sj];
        }
        if(si > ei || sj > ej) {
            return Integer.MAX_VALUE;
        }

        int option1 = minCost(matrix, si + 1, sj, ei, ej);
        int option2 = minCost(matrix, si + 1, sj + 1, ei, ej);
        int option3 = minCost(matrix, si, sj + 1, ei, ej);

        return matrix[si][sj] + Math.min(option1, Math.min(option2, option3));
    }

    public static int minCostMemo (int[][] matrix, int si, int sj, int ei, int ej, int[][] memo) {

        if(si == ei && sj == ej) {
            return matrix[si][sj];
        }
        if(si > ei || sj > ej) {
            return Integer.MAX_VALUE;
        }

        if(memo[si][sj] != -1) {
            return memo[si][sj];
        }
 
        int option1 = minCostMemo(matrix, si + 1, sj, ei, ej, memo);
        int option2 = minCostMemo(matrix, si + 1, sj + 1, ei, ej, memo);
        int option3 = minCostMemo(matrix, si, sj + 1, ei, ej, memo);

        int result = matrix[si][sj] + Math.min(option1, Math.min(option2, option3));
        memo[si][sj] = result;
        return result;
    }

    public static int minCostIterative (int[][] matrix, int m, int n) {
        int[][] memo = new int[m][n];

        

        memo[m-1][n-1] = matrix[m-1][n-1];

        for (int i = m -2; i >= 0; i--) {
            memo[i][n-1] = matrix[i][n-1] + memo[i+1][n-1];
        }

        for (int i = n -2; i >= 0; i--) {
            memo[m-1][i] = matrix[m-1][i] + memo[m-1][i+1];
        }

        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                memo[i][j] = matrix[i][j] + Math.min(Math.min(memo[i+1][j], memo[i+1][j+1]), memo[i][j+1]);
            }
        }
        return memo[0][0];
        
    }

}