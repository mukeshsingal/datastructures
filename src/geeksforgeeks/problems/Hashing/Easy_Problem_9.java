package geeksforgeeks.problems.Hashing;

import java.util.HashMap;

/**
 * Check if a given array contains duplicate elements within k distance from each other
 * <p>
 * Given an unsorted array that may contain duplicates. Also given a number k
 * which is smaller than size of array. Write a function that returns true if
 * array contains duplicates within k distance.
 * <p>
 * Examples:
 * <p>
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
 * Output: false
 * All duplicates are more than k distance away.
 * <p>
 * Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
 * Output: true
 * 1 is repeated at distance 3.
 * <p>
 * Input: k = 3, arr[] = {1, 2, 3, 4, 5}
 * Output: false
 * <p>
 * Input: k = 3, arr[] = {1, 2, 3, 4, 4}
 * Output: true
 */
public class Easy_Problem_9 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 4};
        int k = 3;
        HashMap<Integer, Integer> firstIndexes = new HashMap<>();

        boolean containsDuplicate = false;

        for (int i = 0; i < arr.length; i++) {
            if (firstIndexes.containsKey(arr[i])) {
                if (k >= i - firstIndexes.get(arr[i])) {
                    containsDuplicate = true;
                }
            } else {
                firstIndexes.put(arr[i], i);
            }
        }

        System.out.println("Duplicate exist with " + k  + ": " + String.valueOf(containsDuplicate));

    }
}
