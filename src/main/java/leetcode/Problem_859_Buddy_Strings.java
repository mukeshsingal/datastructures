package leetcode;
//https://leetcode.com/problems/buddy-strings/
public class Problem_859_Buddy_Strings {
    public boolean buddyStrings(String s, String goal) {

        if(s.length() != goal.length()) return false;

        int[] chars = new int[26];

        int misplaceCount = 0;

        int firstIndex = -1;
        int secondIndex = -1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i))  {
                misplaceCount++;
                if(firstIndex == -1) {
                    firstIndex = i;
                }
                else {
                    secondIndex = firstIndex;
                    firstIndex = i;
                }
            }
            chars[s.charAt(i) - 'a']++;
        }

        if(misplaceCount > 2) {
            return false;
        }
        else if(misplaceCount == 2) {
            return
                    goal.charAt(secondIndex) == s.charAt(firstIndex)
                            && goal.charAt(firstIndex) == s.charAt(secondIndex);
        }
        else if(misplaceCount == 0) {
            for(int i = 0; i < 26; i++) {
                if(chars[i] >= 2) {
                    return true;
                }
            }
        }
        return false;

    }
}
