package mustdo.DP;

public class SubSetSum {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int change = 7;
        System.out.println(isSubSetSum(coins, coins.length, change));
    }

    static boolean isSubSetSum(int[] arr, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum > 0 && index == 0) {
            return false;
        }

        return isSubSetSum(arr, index - 1, sum) || isSubSetSum(arr, index - 1, sum - arr[index -1]);
    }
}
