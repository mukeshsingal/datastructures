package mustdo.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm :
 * <p>
 * If we are allowed to sell and buy multiple time then using below algoithm we can find
 * maximum profit in stocks
 * 1. find local minima starting from first index
 * To calculate minma arr[i] < arr[i+1]
 * 2. find local maxima starting from first index
 * 3. Create a buy and sell pair and add profit to solution
 * 4. If we haven't reached till the end repeat above steps
 */
public class MaximizeStocksProfit {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        findMinDiff(arr);
    }

    static class Interval {
        int buy, sell;

        public Interval(int buy, int sell) {
            this.buy = buy;
            this.sell = sell;
        }
    }

    private static void findMinDiff(int[] arr) {
        int n = arr.length;
        int i = 0;
        int buy, sell;
        List<Interval> stockIntervals = new ArrayList<>();

        while (i < n - 1) {
            //Find local minima
            while (i < n - 1 && arr[i] > arr[i + 1]) {
                i++;
            }
            if (i == n - 1)
                break;
            buy = i++;

            //Find local maxima
            while (i < n && arr[i] > arr[i - 1]) {
                i++;
            }
            sell = i - 1;

            stockIntervals.add(new Interval(buy, sell));
        }

        int profit = 0;
        for (Interval interval : stockIntervals) {
            profit += (arr[interval.sell] - arr[interval.buy]);
        }

        System.out.println("Total profit : " + profit);
    }
}
