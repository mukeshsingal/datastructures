package leetcode;

//https://leetcode.com/problems/climbing-stairs/
public class Problem_70_Climb_Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n == 1 || n == 2) return n;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }

}