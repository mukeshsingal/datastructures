package mustdo.Greedy;

public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        int n = 1075;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= n) {
                count += (n / arr[i]);
                n = n % arr[i];
            }
            if (n == 0) {
                break;
            }
        }
        System.out.println("TOTAL  " + count);
    }
}
