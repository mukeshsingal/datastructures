package leetcode;

public class Problem_693_Binary_Number_with_Alternating_Bits {

    public boolean hasAlternatingBits(int n) {
        int bit = (n & 1) == 0 ? 0 : 1;
        int nextBit = bit ^ 1;
        n = n >> 1;

        while(n != 0) {
            bit = (n & 1) == 0 ? 0 : 1;
            if(bit != nextBit) {
                return false;
            }
            nextBit = bit ^ 1;
            n = n >> 1;
        }
        return true;
    }
}