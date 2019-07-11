package leetcode;

public class Problem_520_Detect_Capital {

    public boolean detectCapitalUse(String word) {
        char[] str = word.toCharArray();
        int cap = 0;
        int low = 0;
        boolean first = str[0] >= 'a' && str[0] <= 'z';
        for(int i = 1; i < str.length; i++) {
            if(str[i] >= 'a' && str[i] <= 'z')
                low++;
            else
                cap++;
        }
        return (cap != 0 && low ==0 && !first) || (cap ==0 && low != 0) || str.length == 1;
    }
}