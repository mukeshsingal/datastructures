package companies.google;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class Problem1_Sum_of_bit_differences_among_all_pairs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Sum of bit differences in all pairs : " + calculateBitDifference(arr));
    }

    public static int calculateBitDifference(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int count;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & 1 << i) == 0) {
                    count++;
                }
            }
            sum += (count * (n - count) * 2);
        }
        return sum;
    }

}
