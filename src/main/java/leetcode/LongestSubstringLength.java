package leetcode;

import java.util.HashMap;

public class LongestSubstringLength {
    public int lengthOfLongestSubstring(String s) {
        char[] chArray = s.toCharArray();
        int n = chArray.length;
        int maxLength = 0;

        for(int i=0; i<n; i++) {
            String str = "";
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=i; j<n; j++) {
                if(map.containsKey(chArray[j])){
                    break;
                }
                else{
                    map.put(chArray[j], 0);
                }

                str += Character.toString(chArray[j]);
                if(str.length() > maxLength){
                    maxLength = str.length();
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringLength lsl = new LongestSubstringLength();
        System.out.println("String abcsdfe Expected 7, Acutal " + lsl.lengthOfLongestSubstring("abcsdfe"));
    }
}
