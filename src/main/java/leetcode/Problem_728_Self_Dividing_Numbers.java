package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_728_Self_Dividing_Numbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(selfDividingNumbers(i)) {
                arr.add(i);
            }
        }
        return arr;

    }
    private boolean selfDividingNumbers(int num) {
        int x = 0;
        int y = num;
        while(y != 0) {
            x = y % 10;
            y = y / 10;
            if(x == 0 || num % x != 0) {
                return false;
            }
        }
        return true;
    }
}