package leetcode;


import java.util.ArrayList;
import java.util.List;

class Problem_155_min_stack {

    class Element {
        int val;
        int top;
    }

    List<Element> stack;

    /** initialize your data structure here. */
    public Problem_155_min_stack() {
        stack = new ArrayList<Element>();
    }

    public void push(int x) {
        Element elem = new Element();
        elem.val = x;

        int top = x;

        if(stack.size() > 0) {
            Element topElem = stack.get(stack.size()-1);
            top = (x < topElem.top) ? x : topElem.top;
        }

        elem.top = top;
        stack.add(elem);
    }

    public void pop() {
        if(stack.size() > 0) {
            stack.remove(stack.size()-1);
        }
    }

    public int top() {
        if(stack.size() > 0) {
            return stack.get(stack.size()-1).val;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getMin() {
        if(stack.size() <= 0) {
            return Integer.MIN_VALUE;
        }

        Element topElem = stack.get(stack.size()-1);
        return topElem.top;
    }
}