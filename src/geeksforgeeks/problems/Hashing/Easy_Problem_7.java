package geeksforgeeks.problems.Hashing;

import java.util.HashMap;

/**
 * Maximum distance between two occurrences of same element in array
 *
 * Given an array with repeated elements, the task is to find the maximum distance two occurrences of an element.
 *
 * Examples:
 *
 * Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
 * Output: 10
 * // maximum distance for 2 is 11-1 = 10
 * // maximum distance for 1 is 4-2 = 2
 * // maximum distance for 4 is 10-5 = 5
 *
 */
public class Easy_Problem_7 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};

        HashMap<Integer, Integer> firstIndices = new HashMap<>();

        int maximumDistance = 0;

        for (int i = 0; i < arr.length; i++) {
            if(!firstIndices.containsKey(arr[i])){
                firstIndices.put(arr[i], i);
            }
            else {
                int temp = i - firstIndices.get(arr[i]);
                if(temp > maximumDistance) {
                    maximumDistance = temp;
                }
            }
        }

        System.out.println("Maximum distance is " + maximumDistance);

    }
}
