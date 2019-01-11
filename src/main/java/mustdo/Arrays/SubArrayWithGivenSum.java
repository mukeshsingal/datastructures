package mustdo.Arrays;

/**
 * Algorithm:
 * Use variable length sliding window and maintain sum of window
 * 1. if windows sum > key then
 *      start removing element from start
 *      and keep removing till sum becomes less then key
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int n = 2;
        getMissingNumber(arr, n);
    }

    public static void getMissingNumber(int[] arr, int sum) {
        int startIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];

            if (currentSum > sum) {
                while (currentSum > sum) {
                    currentSum -= arr[startIndex];
                    startIndex++;
                }
            }

            if (currentSum == sum) {
                System.out.println("Start " + startIndex);
                System.out.println("End " + i);
                break;
            }
        }
    }
}
