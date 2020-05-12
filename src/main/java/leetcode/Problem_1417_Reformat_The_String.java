package leetcode;

public class Problem_1417_Reformat_The_String {
    
}

class Solution {
    public String reformat(String s) {
        char[] newS = new char[s.length()];

        int letters = 0;
        char[] sArr = s.toCharArray();

        for (char c : sArr) {
            if (c >= 'a' && c <= 'z') {
                letters++;
            }
        }

        int numbers = s.length() - letters;

        if (Math.abs(numbers - letters) > 1) {
            return "";
        }

        int l = letters > numbers ? 0 : 1;
        int n = l ^ 1;
        for (char c : sArr) {
            if (c >= 'a' && c <= 'z') {
                newS[l] = c;
                l += 2;
            } else {
                newS[n] = c;
                n += 2;
            }
        }

        return String.valueOf(newS);
    }
}