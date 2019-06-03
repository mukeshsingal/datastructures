package leetcode;

import java.util.Stack;


/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures
 * T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 */

public class Problem_739_Daily_Temperatures {
    /**
     * Idea: if i < j and T[i] > T[j] then we don't need to worry about T[j] as all the element before i
     * will have nearest largest number will be T[i]
     */
    public int[] dailyTemperatures(int[] T) {

        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();

        for(int i = T.length -1; i >= 0; i--) {
            // Keep popping until we find element which is greater then  T[i] or stack is empty.
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ans;
    }
}
