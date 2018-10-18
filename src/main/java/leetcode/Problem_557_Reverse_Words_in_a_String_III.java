package leetcode;

public class Problem_557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int ws = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ' ') {
                reverseString(ch, ws, i-1);
                ws = i+1;
            }
        }
        reverseString(ch, ws, ch.length-1);
        return new String(ch);
    }
    public void reverseString(char[] chars, int left, int right) {
        while (left<right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
    }
}
