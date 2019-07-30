package leetcode;

import java.util.HashSet;

public class Problem_888_Fair_Candy_Swap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sA = 0, sB = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int a: A) sA+=a;

        for(int b: B) {
            set.add(b);
            sB+=b;
        }

        int delta = (sB - sA) /2;

        for(int a: A) {
            if(set.contains(a + delta)) {
                return new int[] {a, a + delta};
            }
        }
        return null;
    }
}