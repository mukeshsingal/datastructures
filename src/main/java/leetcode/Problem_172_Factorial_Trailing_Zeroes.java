package leetcode;

public class Problem_172_Factorial_Trailing_Zeroes {
    
    public int trailingZeroes(int n) {
        int result =0;
        while(n != 0) {
            result += n/5;
            n = n/5;
        }
        return result;
    }
}