package leetcode;

import java.util.Stack;

public class Problem_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {

}

class Solution {
    public String reverseParentheses(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                int start = stack.pop();
                int end = i;
                reverse(sb, start, end);
            }
            else if(s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        
        for(int i = sb.length()-1; i >= 0; i--) {
            if(sb.charAt(i) == '(' || sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
    
    public void reverse(StringBuilder s, int start, int end) {
        
        start = start + 1;
        end = end - 1;
        int len = end - start;
        for(int i = 0; i <= len/2; i++) {
            char temp = s.charAt(start+i);
            s.setCharAt(start+i, s.charAt(end-i));
            s.setCharAt(end-i, temp);
        }
    }
    
}