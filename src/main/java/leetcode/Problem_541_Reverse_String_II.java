package leetcode;

public class Problem_541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        if(ch.length < k){
            reverseString(ch, 0, ch.length-1);
        }
        else{
            for(int i = 0; i < ch.length; i += 2*k){

                reverseString(ch, i, Math.min(i+k-1, ch.length-1));
            }
        }
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
