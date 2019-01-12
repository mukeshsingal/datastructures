package mustdo.Arrays;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        //int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60};
        //int[] arr = {3, 10, 2, 1, 20};
        //int[] arr = {3, 1};
        int[] arr = {50, 3, 10, 7, 40, 80};

        getLongestIncreasingSequence(arr);
    }

    /**
     * Algorithm is based on Dynamic programming approach
     *
     *
     */
    public static void getLongestIncreasingSequence(int[] arr){
        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);

        int maxLength = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] <= arr[i] && lengths[i] <= lengths[j]) {
                    lengths[i] = lengths[j] + 1;
                    if(lengths[i] > maxLength)
                        maxLength = lengths[i];
                }
            }
        }
        System.out.println(Arrays.toString(lengths));
        System.out.println("Max Length " + maxLength);
    }
}
