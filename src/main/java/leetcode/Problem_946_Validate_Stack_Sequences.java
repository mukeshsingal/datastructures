package leetcode;

import java.util.Stack;

public class Problem_946_Validate_Stack_Sequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        while (j != popped.length) {
            if(i < pushed.length && popped[j] == pushed[i]) {
                i++;
                j++; 
                continue;
            }
            if(stack.isEmpty() || popped[j] != stack.peek()) {
                if(i == pushed.length) {
                    return false;
                }
                stack.push(pushed[i]);
                i++;
            }
            else {
                stack.pop();
                j++;
            }
        }
        return true;
    }
}