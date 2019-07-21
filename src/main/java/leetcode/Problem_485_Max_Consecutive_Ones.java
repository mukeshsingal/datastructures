package leetcode;

public class Problem_485_Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
                if(n < count) n = count;
            }
            else {
                count = 0;
            }
        }
        return n;
    }
}