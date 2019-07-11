package leetcode;

public class Problem_645_Set_Mismatch {

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length +1];

        int sum = ((nums.length)*(nums.length +1))/2;

        int num = -1;

        for(int i = 0 ; i < nums.length; i++) {
            if(arr[nums[i]] == 1) {
                num = nums[i];
                continue;
            }
            arr[nums[i]] = 1;
            sum = sum - nums[i];
        }

        int result[] = new int[2];
        result[0] = num;
        result[1] = sum;

        return result;
    }
}