package geeksforgeeks.problems.dynamic_programming;

public class Problem_9_CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChnage(new int[]{1,2,3}, 3, 4));
    }

    public static int coinChnage(int[] coins, int i, int N) {
        if (N == 0) {
            return 1;
        }
        if (N < 0)
            return 0;

            if (i <=0 && N >= 1) 
            return 0; 
        
        return coinChnage(coins, i-1,  N) + coinChnage(coins, i, N-coins[i-1]);
        
    }
}
