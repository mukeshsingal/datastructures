package leetcode;

public class Problem_169_Majority_Element {

    public int majorityElement(int[] nums) {
        int result = nums[0], count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {

                result = nums[i];
                count = 1;

            } else if (result == nums[i]) {

                count++;

            } else {

                count--;
            }
        }

        return result;
    }
}