package mustdo.Arrays;

/**
 * Algorithm sum of elements in sum variable and then traverse array
 * Calculate left and right sum
 * if left sum == right sum then return
 * else update left sum
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 1, 1};
        System.out.println("Equilibrium index : " + getEquilibriumIndex(arr));
    }

    public static int getEquilibriumIndex(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = sum - arr[i] - leftSum;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
