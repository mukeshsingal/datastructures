package geeksforgeeks.problems.matrix;

//https://practice.geeksforgeeks.org/problems/paths-to-reach-origin/0

public class Problem3_Paths_to_reach_origin {
    public static void main(String[] args) {
        int[][] testCases = {{3, 2},
                {3, 6},
                {3, 0}};
        for (int[] testCase : testCases) {
            System.out.println(countPathsDP(testCase[0],testCase[1]));
        }
    }
    private static int countPaths(int n, int m ){
        if( n == 0 && m == 0) {
            return 1;
        }
        if(n < 0 || m < 0) {
            return 0;
        }
        return countPaths(n-1, m) + countPaths(n, m -1);
    }

    private static int countPathsDP(int n, int m){
        int[][] DP = new int[n+1][m+1];
        DP[0][0] = 0;
        for(int i =0; i <= n; i++) {
            for(int j =0; j <= m; j++) {
                if(i ==0 || j ==0) {
                    DP[i][j] = 1;
                }
                else {
                    DP[i][j] = DP[i-1][j] + DP[i][j-1];
                }
            }
        }
        return DP[n][m];
    }
}

