package leetcode;

import java.util.Arrays;

class Problem_121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int [] minima = Arrays.copyOf(prices, prices.length);
        int [] maxima = Arrays.copyOf(prices, prices.length);

        int minimumSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < minima.length; i++) {
            if(minimumSoFar >  minima[i])
                minimumSoFar = minima[i];
            else
                minima[i] = minimumSoFar;
        }

        int maxmumSoFar = Integer.MIN_VALUE;
        for(int i = minima.length -1; i >= 0; i--) {
            if(maxmumSoFar <  maxima[i])
                maxmumSoFar = maxima[i];
            else
                maxima[i] = maxmumSoFar;
        }

        int maxProfile = 0;
        for(int i = 0; i < minima.length; i++) {
            if(maxima[i] -  minima[i] > maxProfile)
                maxProfile = maxima[i] -  minima[i];
        }
        return maxProfile;
    }
}