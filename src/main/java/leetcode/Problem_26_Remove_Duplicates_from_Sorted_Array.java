package leetcode;

public class Problem_26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int i = 0;
        int j = 1;

        while(j < nums.length) {
            if(nums[j] == nums[i]) {
                j++;
            }
            else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}