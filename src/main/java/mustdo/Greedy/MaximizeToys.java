package mustdo.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximizeToys {
    public static void main(String[] args) {
        int[] arr = {1, 12, 5, 111, 200, 1000, 10, 9, 12, 15};
        Arrays.sort(arr);
        
        int n = 200;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= n){
                n = n - arr[i];
                System.out.println(arr[i]);
                count++;
            }
            else
                break;

        }
        System.out.println("TOTAL  " + count);
    }
}
