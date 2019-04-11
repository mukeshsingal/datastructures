package CodingNinja.BitMasking;
import java.util.Arrays;

public class Candy {
    long solve(int[][] like, int N){
        int[] dp = new int[1 << N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return noOfWays(like, 0, N, 0,dp);

    }

    int noOfWays(int[][] like, int assignedCandies, int noOfStudents, int mask, int[] dp) {
        if(assignedCandies >= noOfStudents) {
            return 1;
        }
        if(dp[mask] != Integer.MIN_VALUE){
            return dp[mask];
        }
        int count = 0;
        for(int i =0 ;i < noOfStudents; i++) {

            //check if ith Bit is set
            if((mask & (1 << i)) == 0 && like[assignedCandies][i] == 1) {
                count = count + noOfWays(like, assignedCandies +1, noOfStudents, mask | (1 << i), dp);
            }
        }
        dp[mask] = count;
        return count;
    }
}
