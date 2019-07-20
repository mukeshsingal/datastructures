package leetcode;

public class Problem_58_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        if(s.trim().isEmpty()) return 0;
        int i = s.length() -1;
        int size = 0;
        while(s.charAt(i) == ' ') {
            i--;
        }

        while(i >= 0 && s.charAt(i) != ' ') {
            size++;
            i--;
        }
        return size;
    }
}