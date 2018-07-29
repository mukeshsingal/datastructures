package geeksforgeeks.string;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * This will print all permutation of String.(Duplicates Not allowed)
 * Permutation of string "ABC" will be "ABC", "BAC", "CAB", "BCA", "CBA", "ACB"
 * <p>
 * For string of length n, there are n! possible arrangements are possible.
 * <p>
 * <p>
 * <p>
 * Recurrence relation:
 * T(n) = N * (O(1) + T(N-1) +O(1)) = N!
 * Print Takes N,
 * <p>
 * Time Complexity : N * N!
 * Space Complexity :
 */

public class PrintAllPermutationOfStringWithDuplicate {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        StringBuffer abc = new StringBuffer("ABCC");
        permute(abc.toString().toCharArray());
        double timeTaken = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println("Time taken : " + timeTaken);
    }

    public static void permute(char[] string) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : string) {
            countMap.compute(ch, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
        System.out.println(countMap);
    }
}
