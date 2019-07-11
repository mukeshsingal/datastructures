package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_830_Positions_of_Large_Groups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> gList = new ArrayList<>();

        if(S.length() < 2) {
            return gList;
        }

        int i = 0;
        int j = 1;

        while(j != S.length()) {
            if(S.charAt(j) != S.charAt(i) && j - i >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j-1);
                gList.add(list);
                i = j;
            }
            else if(S.charAt(j) != S.charAt(i)  && j - i - 1 < 3) {
                i = j;
            }
            j++;
        }
        if(j - i >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j-1);
            gList.add(list);
        }
        return gList;
    }
}

