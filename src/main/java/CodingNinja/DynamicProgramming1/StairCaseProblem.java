package CodingNinja.DynamicProgramming1;

public class StairCaseProblem {

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Stair Case " + staircase(n));
        
        long[] arr = new long[n + 1];
        System.out.println("Stair Case Memo " + staircaseMemo(n, arr));
        System.out.println("Bottom Up " + staircaseIterative(n));
    }

    public static long staircase(int n){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;

        return staircase(n-1) + staircase(n-2) + staircase(n-3);
    }

    public static long staircaseMemo(int n, long[] arr){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        if(arr[n] > 0) {
            return arr[n];
        }
        arr[n] = staircaseMemo(n-1, arr) + staircaseMemo(n-2, arr) + staircaseMemo(n-3, arr);
        return arr[n];
    }

    public static long staircaseIterative(int n){

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

