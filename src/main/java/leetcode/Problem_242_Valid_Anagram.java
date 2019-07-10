package leetcode;

public class Problem_242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {

        if(t.length() != s.length()) {
            return false;
        }

        int[] arr = new int[26];

        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            arr[sArr[i] - 'a']++;
            arr[tArr[i] - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
}