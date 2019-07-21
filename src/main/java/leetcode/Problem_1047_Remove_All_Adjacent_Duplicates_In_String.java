package leetcode;

public class Problem_1047_Remove_All_Adjacent_Duplicates_In_String {

    public String removeDuplicates(String S) {
        if(S.length() == 0 ||S.length() == 1) return S;

        char[]  c = S.toCharArray();
        StringBuilder s = new StringBuilder();

        int length = 0;
        for(int i = 0; i < c.length; i++) {
            length = s.length()-1;
            if(length >=0 && s.charAt(length) == c[i]) {
                s.deleteCharAt(length);
                continue;
            }
            s.append(c[i]);
        }
        return s.toString();
    }
}