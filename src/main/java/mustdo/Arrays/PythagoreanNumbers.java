package mustdo.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class PythagoreanNumbers {
    public static void main(String[] args) {
        //int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60};
        //int[] arr = {3, 10, 2, 1, 20};
        //int[] arr = {3, 1};
        //int[] arr = {50, 3, 10, 7, 40, 80};
        int[] arr = {3, 2, 4, 5};

        System.out.println(isPythagoreanTripletExist(arr));
    }

    private static boolean isPythagoreanTripletExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i])
                    return true;
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }

}

