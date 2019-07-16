package leetcode;

public class Problem_7_Reverse_Integer {

    public int reverse(int x) {
        String maxValue = String.valueOf(Integer.MAX_VALUE);
        String minValue = String.valueOf(Integer.MIN_VALUE);
        String input = String.valueOf(x);

        String peekNumString = minValue;
        int maxlength = minValue.length();
        int val = maxlength;

        if(x >= 0) {
            peekNumString =  maxValue;
            maxlength =  maxValue.length();
            val =  maxlength - 1;
        }

        if(input.length() == maxlength) {
            for(int i = maxlength-1; i >= 0; i--) {

                int numInInputValue = input.charAt(i) - '0';
                int numInMaximumValue = peekNumString.charAt(val - i) - '0';

                if(numInMaximumValue < numInInputValue) {
                    return 0;
                }
                else if(numInInputValue == numInMaximumValue) {
                    continue;
                }
                else {
                    break;
                }
            }
        }

        int result = 0;
        while(x != 0) {
            int rem = x % 10;
            x = x/10;
            result = result * 10 + rem;
        }

        return result;
    }
}