package leetcode;

import java.util.ArrayList;

public class Problem_5131_Minimum_Cost_Tree_From_Leaf_Values {
    
    public int mctFromLeafValues(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i :arr) {
            list.add(i);
        }
        while(list.size() != 1) {
            int index = 0;
            int p = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size() -1; i++) {
                p = list.get(i) * list.get(i+1);
                if(min > p) {
                    min = p;
                    index = i;
                }
            }
            int val = Math.max(list.get(index), list.get(index+1));
            list.remove(index);
            list.remove(index);
            sum += min;
            list.add(index, val);
        }
        return sum;
    }
}