package geeksforgeeks.problems.dynamic_programming;

public class Problem_4_Bell_Numbers {

    public static void main(String[] args) {
        System.out.println("Bell " + bellNumber(5));
    }

    public static int bellNumber(int n) {
        int[][] bell = new int[n+1][n+1];

        bell[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i-1][i-1]; 
            
            for (int j=1; j<=i; j++) 
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1]; 
        }
        return bell[n][0]; 
    }
}

