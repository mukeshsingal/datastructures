package CodingNinja.DynamicProgramming1;

public class Fibbonaci1 {
    public static void main(String[] args) {
        Fibbonaci1 series = new Fibbonaci1();
        
        //System.out.println(series.fib(5));
        int n = 30;
        //int[] arr = new int[n+1];  
        //System.out.println(series.fibWithMemo(n, arr));

        System.out.println(series.iterativeFib(n));
    }
    /**
     * 
     * @param n
     * @return nth fibbo number
     * 
     * It is going to very slow. If  you look at function calls most of calls are getting repeated. at most nth level in recusion it will have 2^n calls. 
     * Which is exponential.
     * 
     */
    public int fib(int n) {
        if(n ==0 || n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    
    public int fibWithMemo(int n, int[] arr) {
        if(n ==0 || n == 1) {
            return 1;
        }
        if(arr[n] > 0) {
            return arr[n];
        }
        //Save, as we did work for n here, save it for future use
        arr[n] = fibWithMemo(n-1, arr) + fibWithMemo(n-2, arr);
        return arr[n];
    }

    public int iterativeFib(int n) {
        int[] array = new int[n+2];

        array[0] = 1;
        array[1] = 1;

        for(int i = 2; i <= n; i++) {
            array[i] = array[i-1]+ array[i-2]; 
        }
        return array[n];
    }
}
