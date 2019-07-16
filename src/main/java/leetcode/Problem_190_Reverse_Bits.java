package leetcode;

public class Problem_190_Reverse_Bits {

    public int reverseBits(int n) {

        for(int i = 0; i<16; i++) {
            int lastBit = (n & (1 << i));
            int firstBit = (n & (1 << 31-i));
            if(lastBit != 0 ^ firstBit !=0) {
                n = n ^ (1 << (i));
                n = n ^ (1 << (31-i));
            }
        }
        return n;
    }
}
