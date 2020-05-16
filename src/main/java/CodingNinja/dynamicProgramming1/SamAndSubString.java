package CodingNinja.DynamicProgramming1;

public class SamAndSubString {

    public static long count(String s) {

        char [] c = s.toCharArray();

        long totalSum = c[0] - '0';
        long lastValue = c[0] - '0';
        
        for(int i = 1; i < c.length; i++) {
            lastValue = lastValue * 10 + (c[i] - '0') * (i+1);
            totalSum += lastValue;
        }
        return totalSum;
        
    }
}
