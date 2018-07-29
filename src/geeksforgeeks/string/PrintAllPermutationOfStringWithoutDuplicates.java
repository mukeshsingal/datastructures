package geeksforgeeks.string;


/**
 * This will print all permutation of String.(Duplicates Not allowed)
 * Permutation of string "ABC" will be "ABC", "BAC", "CAB", "BCA", "CBA", "ACB"
 * <p>
 * For string of length n, there are n! possible arrangements are possible.
 * <p>
 * <p>
 *
 * Recurrence relation:
 * T(n) = N * (O(1) + T(N-1) +O(1)) = N!
 * Print Takes N,
 *
 * Time Complexity : N * N!
 * Space Complexity :
 */

public class PrintAllPermutationOfStringWithoutDuplicates {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        StringBuffer abc = new StringBuffer("ABC");
        permute(abc, 0, abc.length() - 1);

        double timeTaken = (System.nanoTime() - startTime)/1000000000.0;
        System.out.println("Time taken : " + timeTaken);
    }

    public static void permute(StringBuffer string, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (leftIndex == rightIndex) {
                System.out.println(string);
            } else {
                swap(string, leftIndex, i);
                permute(string, leftIndex + 1, rightIndex);
                swap(string, leftIndex, i);

            }
        }
    }

    public static void swap(StringBuffer string, int index1, int index2) {
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }
}
