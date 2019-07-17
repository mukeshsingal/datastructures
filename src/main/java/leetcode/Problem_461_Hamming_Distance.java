package leetcode;

public class Problem_461_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        int hDistance = 0;

        for (int i = 0; i < 32; i++) {
            int a = x & 1;
            int b = y & 1;
            if(a != b) {
                hDistance++;
            }
            x=x>>1;
            y=y>>1;
        }
        return hDistance;
    }
}