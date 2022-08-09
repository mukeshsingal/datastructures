package leetcode;
import java.util.HashMap;
//https://leetcode.com/problems/contains-duplicate-ii/

public class Problem_219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if(nums == null || nums.length <= 1)
            return false;

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            else {
                if(Math.abs(i - map.get(nums[i])) <=k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}