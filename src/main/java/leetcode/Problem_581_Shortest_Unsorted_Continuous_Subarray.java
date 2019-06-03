package leetcode;

import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this
 * subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 */
public class Problem_581_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {

        Stack<Integer> stack = new Stack<Integer>();

        int l = nums.length, r = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

}
