package leetcode;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even they consist of same characters.
 */
public class Problem_647_Palindromic_Substrings {

    /**
     * Idea: If a subString at index i is palindrome and T[i-1] == T[i+1] then
     * we can conclude that T has substring from i-1 to i+1 is palindrome.
     */
    public int countSubstrings(String S) {
        int ans =0, N = S.length();
        for(int center = 0; center <= 2*N -1; center++) {
            int i = center/2;
            int j = i + (center % 2);
            while(i>=0 && j < N && S.charAt(i) == S.charAt(j)) {
                ans++;
                i--;
                j++;
            }
        }
        return ans;
    }
}