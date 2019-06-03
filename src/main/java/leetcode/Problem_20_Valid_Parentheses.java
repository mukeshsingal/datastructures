package leetcode;

import java.util.Stack;

public class Problem_20_Valid_Parentheses {

    public boolean isValid(String s) {
        int len = s.length();

        Stack<Character> stack = new Stack<>();

        for(int i =0; i < len; i++) {
            if(!stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']'  || s.charAt(i) == '}')) {
                if(isValidString(s.charAt(i), stack.peek().charValue())) {
                    stack.pop();
                    continue;
                }
                else
                    return false;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
    public boolean isValidString(char c, char peek) {
        if(c == ')' && peek != '(')
            return false;
        if(c == '}' && peek != '{')
            return false;
        if(c == ']' && peek != '[')
            return false;
        return true;
    }
}