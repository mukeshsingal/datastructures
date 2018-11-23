package algo.dp;

public class KnapSackProblem {

    public static int knapSack(int knapSackCapacity, int[] weights, int[] values, int n) {
        if (knapSackCapacity <= 0 || n == 0) {
            return 0;
        }

        if (weights[n - 1] > knapSackCapacity)
            return knapSack(knapSackCapacity, weights, values, n - 1);
        else {
            return Math.max(
                    knapSack(knapSackCapacity, weights, values, n - 1), //not included
                    values[n - 1] + knapSack(knapSackCapacity - weights[n - 1], weights, values, n - 1)
            );
        }
    }

    public static int knapSackWithoutOverlapping(int knapSackCapacity, int[] weights, int[] values, int totalItemsCount) {
        int i, w;
        int[][] matrix = new int[totalItemsCount + 1][knapSackCapacity + 1];

        //Build Matrix K[][] in bottom up manner
        for (i = 0; i <= totalItemsCount; i++) {
            for (w = 0; w <= knapSackCapacity; w++) {
                if (i == 0 || w == 0) {
                    matrix[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    matrix[i][w] = Math.max(
                            matrix[i - 1][w - weights[i - 1]] + values[i - 1],
                            matrix[i - 1][w]
                    );
                }
            }
        }

        return matrix[totalItemsCount][knapSackCapacity];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int knapSackCapacity = 50;
        int allItemsCount = val.length;
        System.out.println(knapSackWithoutOverlapping(knapSackCapacity, wt, val, allItemsCount));
    }
}
