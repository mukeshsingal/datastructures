package geeksforgeeks.problems.general;

public class Fibonacci {

    public static int[] fib = new int[20];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println("Fibonacci of " + i + " is " + fibo(i));
    }

    /*Using DP : memoization Bottom up approach O(N) in time and O(N) in space*/
    static int fibonacciUsingMemoization(int n) {
        if (n == 0 || n == 1) return 1;
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /*Using DP : memoization Bottom up approach O(N) in time and O(1) in space*/
    static int fibonacciUsingMemoizationWithReducedSpace(int n) {
        if (n == 0 || n == 1) return 1;
        int num1 = 1;
        int num2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = num1 + num2;
            num1 = num2;
            num2 = fib;
        }
        return fib;
    }

    /*Using DP: memoization Top down approach */
    public static int fibo(int n) {
        if (n == 1 || n == 0) return 1;
        // reduce the recursive calls and use the values if they are already computed.
        if (fib[n] != 0) return fib[n];
        return fib[n] = fibo(n - 1) + fibo(n - 2);
    }

    /* Using recursion */
    static int fibonacci(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
