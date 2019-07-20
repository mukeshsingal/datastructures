package leetcode;

public class Problem_171_Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            num = num + (int)Math.pow(26, s.length()-i-1)*(s.charAt(i) - 'A' + 1);
        }
        return num;
    }
}