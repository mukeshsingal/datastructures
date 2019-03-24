package CodingNinja.dynamicProgramming1;

public class StairCaseProblem {


    public static long staircase(int n){

        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for(int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n-1];
    }
}
