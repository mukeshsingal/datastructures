package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem_350_Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i: nums2) {
            if(map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i)-1);
                list.add(i);
            }
        }
        int size = list.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer i : list) {
            result[index] = i;
            index++;
        }
        return result;
    }
}