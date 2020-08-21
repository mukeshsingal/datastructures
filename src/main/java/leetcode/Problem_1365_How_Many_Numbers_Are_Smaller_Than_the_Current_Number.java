package leetcode;

public class Problem_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] map = new int[101];
        
        for(int i: nums) {
            map[i]++;
        };
        
        int count = 0;
        for(int i = 0; i < 101; i++) {
            int freq = map[i];
            map[i] = count;
            count += freq;
        }
        int[] output = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            output[i] = map[nums[i]];
        }
        return output;
    }
}