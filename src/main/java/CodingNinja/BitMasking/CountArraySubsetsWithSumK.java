package CodingNinja.BitMasking;

/**
 * input : {1, 2, 3, 4, 5, 6};
 * output : 4
 * (1 2 3), (2 4), (1 5), (6)
 *
 * Time Complexity: n * 2^n
 * Space Complexity = O(1)
 */
public class CountArraySubsetsWithSumK {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int K = 6;

        //Using bitMasking
        int totalSubsets = (1 << arr.length) - 1;
        int count = 0;
        for (int mask = 0; mask < totalSubsets; mask++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            if (sum == K) {
                count++;
            }
        }

        System.out.println(count);
    }
}
