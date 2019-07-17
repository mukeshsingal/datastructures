package leetcode;

public class Problem_268_Missing_Number {

    public int missingNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; i++) {
            x^=nums[i];
            x^=i;
        }
        x^=nums.length;

        return x;
    }
}