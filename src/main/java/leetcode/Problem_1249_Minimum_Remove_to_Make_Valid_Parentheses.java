package leetcode;

import java.util.Stack;

public class Problem_1249_Minimum_Remove_to_Make_Valid_Parentheses {

    
    /* 1249. Minimum Remove to Make Valid Parentheses */
    /*
        Algorithm:
        Keep two stacks. 1. Keep the parenthesis and other the index from string
        if balance remove from both the stacks
    */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        Stack<Character> parenthesisStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') continue;
            
            if(parenthesisStack.isEmpty()) {
                parenthesisStack.push(c);
                indexStack.push(i);
            }
            else {
                char top = parenthesisStack.peek();
                if(c == ')' && top == '(') {
                    parenthesisStack.pop();
                    indexStack.pop();
                }
                else {
                   parenthesisStack.push(c);
                   indexStack.push(i); 
                }
            }
        }
        while(!parenthesisStack.isEmpty()) {
            parenthesisStack.pop();
            int index = indexStack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}