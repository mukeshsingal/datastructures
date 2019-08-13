package leetcode;

import java.util.HashSet;

public class Problem_202_Happy_Number {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n) && n != 1) {
            set.add(n);
            n = getNew(n);
        }
        return n == 1;
    }
    private int getNew(int n) {
        int count = 0;
        while(n / 10 != 0) {
            count += (n%10) * (n%10);
            n = n/10;
        }
        count += (n%10) * (n%10);
        return count;
    }
}