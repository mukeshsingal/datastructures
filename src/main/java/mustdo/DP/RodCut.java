package mustdo.DP;

import java.util.Arrays;

public class RodCut {
    public static void main(String[] args) {
        int[] coins = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum profit is : " + rodCut(coins, coins.length));
    }

    public static int rodCut(int[] profits, int rodLength) {
        int[] table = new int[rodLength + 1];
        table[0] = 0;
        int max_val = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, profits[j] + table[i - j - 1]);
            }
            table[i] = max_val;
        }

        System.out.println(Arrays.toString(table));
        return table[rodLength];
    }
}
