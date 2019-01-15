package mustdo.DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int change = 4;
        System.out.println("Njumber of ways to make a change " + coinChangeRec(coins, coins.length, change));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                combinations[j] += combinations[j - coins[i]];

        return combinations[amount];
    }

    public static int coinChangeRec(int[] coins, int elementTraversed, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }

        if (elementTraversed <= 0 && amount >= 1) {
            return 0;
        }

        return coinChangeRec(coins, elementTraversed - 1, amount) +
                coinChangeRec(coins, elementTraversed, amount - coins[elementTraversed - 1]);


    }
}
