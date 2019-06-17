package leetcode;

import java.util.Stack;

class Problem_394_Decode_String {
    // s = "3[a]2[bc]", return "aaabcbc".
    // s = "3[a2[c]]", return "accaccacc".
    // s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
    public String decodeString(String s) {
        String result = "";
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)  == ']') {

                String stackStr = "";

                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    stackStr = stack.pop() + stackStr;
                }

                stack.pop();
                String number = "";

                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    number = stack.pop() + number;
                }

                stack.push(stringNTimes(Integer.valueOf(number), stackStr));
            }
            else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }

        return result;
    }

    public String stringNTimes(int times, String s) {
        String str = s;
        for(int i = 0; i < times-1; i++)
            s = s + str;
        return s;
    }
}

