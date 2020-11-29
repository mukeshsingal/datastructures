package leetcode;

public class Problem_1672_Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int maxMoney = Integer.MIN_VALUE;

        for (int i = 0; i < accounts.length; i++) {
            int localSum = 0;

            for(int money : accounts[i]) {
                localSum += money;
            }

            maxMoney = Math.max(localSum, maxMoney);
        }
        return maxMoney;
    }
}