package leetcode;

public class Problem_283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int pointer = 0;
        int i = 0;
        while (pointer != nums.length && nums[pointer] != 0) {
            pointer++;
        }
        if (pointer != nums.length) {
            i = pointer;
            pointer++;

            while (pointer != nums.length) {
                if (nums[pointer] == 0) {
                    pointer++;
                    continue;
                }
                nums[i] = nums[pointer];
                i++;
                pointer++;
            }
            while (i != nums.length) {
                nums[i] = 0;
                i++;
            }
        }
    }
}