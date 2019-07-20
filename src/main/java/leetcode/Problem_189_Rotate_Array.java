package leetcode;

public class Problem_189_Rotate_Array {

    public void rotate(int[] nums, int k) {
        while(k >= nums.length) {
            k = k - nums.length;
        }
        int[] arr = new int[k];
        int t = k-1;
        int size = nums.length -1;
        while(t >= 0){
            arr[t] = nums[size];
            t--;
            size--;
        }
        for(int i = nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }

        for(int i = 0; i<k; i++) {
            nums[i] = arr[i];
        }

    }
}