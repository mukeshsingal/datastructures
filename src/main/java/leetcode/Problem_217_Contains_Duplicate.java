package leetcode;

import java.util.HashSet;
//https://leetcode.com/problems/contains-duplicate/
public class Problem_217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) {
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
