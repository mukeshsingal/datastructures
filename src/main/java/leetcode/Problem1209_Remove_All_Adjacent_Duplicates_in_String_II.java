package leetcode;
import java.util.Stack;

class Problem1209_Remove_All_Adjacent_Duplicates_in_String_II {
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
}


class Solution2 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                count.push(1);
            }
            else {
                if(stack.peek() == c) {
                    if(count.peek() == k-1) {
                        int x = 0;
                        while(x != k-1) {
                            stack.pop();
                            count.pop();
                            x++;
                        }    
                    }
                    else {
                        stack.push(c);
                        count.push(count.peek() + 1);
                    }
                    
                }
                else {
                    stack.push(c);
                    count.push(1);
                }
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
            