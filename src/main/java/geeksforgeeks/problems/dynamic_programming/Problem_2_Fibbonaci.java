package geeksforgeeks.problems.dynamic_programming;

public class Problem_2_Fibbonaci {
    public static void main(String[] args) {
        System.out.println("Fib" + fib(10));
        System.out.println("Fib" + fibMemo(10, new int[10+1]));
        System.out.println("Fib" + fibBootomUp(10));
    }

    static int fib(int n) {
        if(n==1) {
            return  1;
        }
        if(n==0) {
            return 0;
        }
        
        return fib(n-1) + fib(n-2);
    }
    static int fibMemo(int n, int[] ans) {
        if(n==1) {
            return  1;
        }
        if(n==0) {
            return 0;
        }
        
        int output = fib(n-1) + fib(n-2);
        ans[n] = output;
        return ans[n];
    }

    static int fibBootomUp(int n) {
        
        int count = 1;

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c;
        while(count != n) {
            c = a + b;
            a = b;
            b = c;
            count++;
        }
        return b;
        
    }
}