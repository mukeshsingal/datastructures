package leetcode;

public class Problem_35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return searchInsert(nums, target, 0, nums.length-1);
    }
    public int searchInsert(int[] arr, int num, int left, int right) {
        if(left == right) {
            if(arr[left] < num) {
                return left +1;
            }
            return left;
        }
        int mid = (left + right)/2;
        if(arr[mid] == num) {
            return mid;
        }
        if(arr[mid] < num) {
            return searchInsert(arr, num, mid+1, right);
        }

        return searchInsert(arr, num, left, mid);

    }
}