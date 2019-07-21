package leetcode;

import java.util.HashMap;

public class Problem_5130_Number_of_Equivalent_Domino_Pairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(int[] arr: dominoes) {
            String s1 = arr[0] + "" + arr[1];
            String s2 = arr[1] + "" + arr[0];

            if(map.containsKey(s1)) {
                count += map.get(s1);
                map.put(s1, map.get(s1) +1);
                continue;
            }
            if(map.containsKey(s2)) {
                count += map.get(s2);
                map.put(s2, map.get(s2) +1);
                continue;
            }

            map.put(s1, 1);
            map.put(s1, 1);

        }
        return count;


    }
}