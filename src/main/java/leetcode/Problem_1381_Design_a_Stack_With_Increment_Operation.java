package leetcode;

public class Problem_1381_Design_a_Stack_With_Increment_Operation {

}

class CustomStack {
    int maxSize = 0;
    int currentSize = 0;
    
    int[] stack; 
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(currentSize == maxSize) {
            return;
        }
        stack[currentSize] = x;
        currentSize++;
    }
    
    public int pop() {
        if(currentSize == 0) {
            return -1;
        }
        int data = stack[currentSize-1];
        currentSize--;
        return data;
    }
    
    public void increment(int k, int val) {
        k = currentSize < k ? currentSize : k;
        for(int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */