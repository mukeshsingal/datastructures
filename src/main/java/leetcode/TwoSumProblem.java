package leetcode;

import java.util.HashMap;

public class TwoSumProblem {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] array = s.twoSum(new int[]{2, 7, 10, 11}, 9);
        System.out.println("Expected [0, 1]");
        System.out.println("Answer [" + array[0] + "," + array[1] + "]");
    }
}

class Solution {

    /*
     * Brute force Solution:
     *
     * TimeComplexity = O(n^2) : check complement of each number with rest all (n) numbers.
     * Space complexity = O(1)


    public int[] twoSum(int[] nums, int target) {
        int lengthOfArray = nums.length;
        int[] result = null;
        for (int i = 0; i < lengthOfArray; i++) {
            for (int j = i + 1; j < lengthOfArray; j++) {
                if (nums[j] == target - nums[i])
                    return result = new int[]{i, j};
            }
        }
        return result;
    }

    */

    /*
     * Two pass HashMap
     *
     * TimeComplexity = O(n)
     * Space complexity = O(N)


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i< nums.length; i++) {
            int complement = target - nums[i];

            if( hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[]{ i, hashMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No solution found with this argument list");
    }
    *//*
     * Two pass HashMap
     *
     * TimeComplexity = O(n)
     * Space complexity = O(N)
        */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found with this argument list");
    }

}