package leetcode;

public class Problem_14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        char[] s = strs[0].toCharArray();
        String common = strs[0];
        StringBuilder n = new StringBuilder();

        for(int i = 1; i < strs.length; i++) {
            char[] t = strs[i].toCharArray();

            int length = s.length < t.length ? s.length : t.length;
            n.delete(0, n.length());
            for(int j = 0; j < length; j++) {
                if(s[j] != t[j]) {
                    break;
                }
                n.append(s[j]);
            }
            if(n.length() < common.length()) {
                common = n.toString();
            }
            if(common.isEmpty()) {
                return "";
            }
        }
        return common;
    }
}
