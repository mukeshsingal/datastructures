package leetcode;

public class Problem_704_Binary_Search {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    public int search(int[] nums, int target, int low, int high) {

        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;

        if(target < nums[mid]) {
            return search(nums, target, low, mid-1);
        }
        else if(target > nums[mid]) {
            return search(nums, target, mid + 1, high);
        }
        else {
            return mid;
        }
    }
}