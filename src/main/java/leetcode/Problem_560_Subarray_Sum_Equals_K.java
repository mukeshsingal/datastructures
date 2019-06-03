package leetcode;

import java.util.HashMap;

/**
 *  Given an array of integers and an integer k,
 *  you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class Problem_560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;

        HashMap < Integer, Integer > map = new HashMap< >();

        map.put(0, 1);

        //We are putting sub array sub from 0 to i index. We calculate sum with current index - k if this is present
        //in Hashmap which mean by excluding the element present in hashmap we can create a subArray whose sum is K.
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
