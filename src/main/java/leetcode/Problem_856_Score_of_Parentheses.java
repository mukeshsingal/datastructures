class Solution {
    public int scoreOfParentheses(String S) {
        return func2(S);
        
//         Stack<Integer> stack = new Stack<>();
        
//         for(char c: S.toCharArray()) {
//             if(c == ')') {
//                 if(stack.peek() == -1) {
//                     stack.pop();
//                     stack.push(1);
//                 }
//                 else{
//                     int n = 0;
//                     while(stack.peek() != -1)
//                         n += stack.pop();
//                     stack.pop();
//                     stack.push(n*2);
//                 }
//                 continue;
//             }
//             stack.push(-1);
//         }
        
//         int x = 0;
//         while(!stack.isEmpty()) {
//             x += stack.pop();
//         }
//         return x;
    }
    public int func2(String s) {
        int ans = 0, l = 0;
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i) == '(') l++;
            else l--;
            if(s.charAt(i) == ')' && s.charAt(i-1) == '(')
                ans += (1<<l);
        }
        return ans;
    }
}