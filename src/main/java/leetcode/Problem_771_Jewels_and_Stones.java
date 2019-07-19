package leetcode;

public class Problem_771_Jewels_and_Stones {

    public int numJewelsInStones(String J, String S) {
        int[] small = new int[26];
        int[] cap = new int[26];

        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if(c >= 'a' && c <= 'z') {
                small[c - 'a']++;
                continue;
            }
            cap[c - 'A']++;
        }
        int result = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c >= 'a' && c <= 'z') {
                if(small[c - 'a'] != 0) {
                    result++;
                }
                continue;
            }
            if(cap[c - 'A'] != 0) {
                result++;
            }
        }
        return result;
    }
}