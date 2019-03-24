package CodingNinja.dynamicProgramming1;


import java.util.Arrays;

public class LargestBiotonicSubsequence {


    public static int longestBitonicSubarray(int[] arr) {

        int[] inc = new int[arr.length];
        int[] dec = new int[arr.length];

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && inc[j] + 1 > inc[i]) {
                    inc[i] = inc[j] + 1;
                }
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[i] && dec[j] + 1 > dec[i]) {
                    dec[i] = dec[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < inc[i] + dec[i]) {
                max = inc[i] + dec[i];
            }
        }

        return max - 1;
    }

}
