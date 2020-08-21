package leetcode;

import java.util.List;
import java.util.LinkedList;

public class Problem_1441_Build_an_Array_With_Stack_Operations {

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new LinkedList<String>();
        
        String push = "Push";
        String pop = "Pop";
        
        int count = 1;
        for(int i = 0; i < target.length; i++) {
            int num = target[i];
            if(num - count != 0) {
                for(int j = 0; j < num - count; j++) {
                    list.add(push);
                    list.add(pop);
                }   
                count = num;
            }
            list.add(push);
            count++;
        }
        return list;
    }
}

