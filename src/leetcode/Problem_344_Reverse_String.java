package leetcode;

public class Problem_344_Reverse_String {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left<right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }

        return new String(chars);
    }
}
