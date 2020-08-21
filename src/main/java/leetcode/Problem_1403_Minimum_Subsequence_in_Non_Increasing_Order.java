package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_1403_Minimum_Subsequence_in_Non_Increasing_Order {

    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int[] freq = new int[101];

        int sum = 0;
        int curSum = 0;
        for (int num:nums) {
            sum += num;
            freq[num]++;
        }
        for (int i = 100; i > 0; i--) {
            if (freq[i] > 0) {
                curSum += i;
                res.add(i);
                freq[i]--;
                if (curSum > sum - curSum)
                    return res;
                else {
                    i++;
                }
            }
        }
        return res;
    }
}