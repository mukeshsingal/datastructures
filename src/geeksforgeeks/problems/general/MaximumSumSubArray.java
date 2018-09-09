package geeksforgeeks.problems.general;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] array = {1, -5, 12, 7, -20, 19};
        System.out.println(solution3(array));
    }

    //Time Complexity: O(n^3). Space Complexity: O(1)
    public static int solution(int[] array) {
        int maximumSum = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) { //start position
            for (int j = i; j < array.length; j++) { //block size
                sum = 0;
                for (int k = i; k <= j; k++) { //cal sum
                    sum += array[k];
                }
                if (sum > maximumSum) {
                    maximumSum = sum;
                }
            }
        }
        return maximumSum;
    }
    //Time Complexity: O(n^2). Space Complexity: O(1)
    public static int solution2(int[] array) {
        int maximumSum = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) { //start position
            sum = 0;
            for (int j = i; j < array.length; j++) { //block size
                sum += array[j];
                if (sum > maximumSum) {
                    maximumSum = sum;
                }
            }
        }
        return maximumSum;
    }

    //Time Complexity: O(n). Space Complexity: O(n), for table.
    public static int solution3(int[] array) {
        int maximumSum = 0; int sum = 0;
        for (int i = 0; i < array.length; i++) { //start position
            sum = Math.max(sum + array[i], array[i]);
            maximumSum = Math.max(sum, maximumSum);
        }
        return maximumSum;
    }
}

