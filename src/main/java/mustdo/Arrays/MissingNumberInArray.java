package mustdo.Arrays;

/**
 * Algorithm 1.
 * -------------------
 * Use sum formula and calculate sum from 1 to N
 * S(n) = n/2(2a + (n-1)d)
 * or
 * S(n) = n(n+1)/2
 * and subtract all the element from the array
 * <p>
 * Algorithm 2.
 * -------------------
 * Xor all the element in array and xor results with number
 * from 1 to N, and result will be missing number
 */
public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 6;
        System.out.println("Missing number is : " + getMissingNumber(arr, n));
        System.out.println("Missing number is : " + getMissingNumber2(arr, n));
    }

    public static int getMissingNumber(int[] arr, int n) {
        int sum = (n * (n + 1)) / 2;
        for (int x : arr) {
            sum -= x;
        }
        return sum;
    }

    public static int getMissingNumber2(int[] arr, int n) {
        int sum = 0;
        for (int x : arr) {
            sum ^= x;
        }
        for (int x = 1; x <= n; x++) {
            sum ^= x;
        }
        return sum;
    }
}
