package geeksforgeeks.problems.array.problems;

import java.util.Arrays;
import java.util.HashMap;
/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * Write a C program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose
 * sum is exactly x.
 *
 * */
public class Problem1 {
    public static void main(String[] args) {
        Solution sol = new Solution3();
        int[] array = {12, 45, 23, 55, 90, 0, 11, 10};
        int[] keysToBeSearched = {10, 0, -23, 46, 100, 90, 45, 66, 23, 21};
        Arrays.stream(keysToBeSearched).forEach(i ->
                sol.findTwoSum(array, i)
        );
    }
}

/**
 * 1) Solution one if to sort using Quick Sort in nLog(n) and then
 * 2) Then initialize two variables left and right which will point to least and
 * rightmost element in array
 * 3) then
 * while (left < right) {
 * if(arr[left] + arr[right] == key) return 1
 * else if( arr[left] + arr[right] < key) left++;
 * else right--;
 * }
 * 4) No element fount then return -1
 * <p>
 * TimeComplexity :
 * Depends on Sorting algorithm, Merge and Heap sort takes nLog(N);
 * If we use quick sort then n^2 in worse case
 * Space: O(N) in merge sort and O(1) in Heap Sort
 */
class Solution1 extends Solution {
    @Override
    public void findTwoSum(int[] arr, int key) {
        Arrays.sort(arr);
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (arr[leftIndex] + arr[rightIndex] == key) {
                System.out.println(arr[leftIndex] + " " + arr[rightIndex]);
                break;
            } else if (arr[leftIndex] + arr[rightIndex] > key) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        if (leftIndex >= rightIndex) {
            System.out.println("No such pairs exist in array.");
        }
    }
}

/**
 * Using HashMap
 * 1) for each element
 * 2) if (key - current element present)
 * found
 * 3) else
 * insert
 */
class Solution2 extends Solution {
    @Override
    public void findTwoSum(int[] arr, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(key - arr[i])) {
                    System.out.println(arr[i] + " " + (key - arr[i]));
                    break;
            } else {
                map.put(arr[i], i);
            }
        }

    }
}
/**
 * This method works in O(n) time if range of numbers is known.
 * 1) for each element
 * 2) if (key - current element  indexed flag is true or not)
 * found
 * 3) else
 * set the flag
 *
 *
 * Auxiliary Space: O(R) where R is range of integers.
 */
class Solution3 extends Solution {
    public static int MAP_SIZE = 10000;

    @Override
    public void findTwoSum(int[] arr, int key) {
        boolean[] map = new boolean[MAP_SIZE];
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (key - arr[i] >= 0 && map[key - arr[i]]  == true) {
                    System.out.println(arr[i] + " " + (key - arr[i]));
                    found = true;
                    break;
            } else {
                map[arr[i]] = true;
            }
        }
        if(!found) {
            System.out.println(" Not found");
        }

    }
}

class Solution {
    public void findTwoSum(int arr[], int key) {
        System.out.println("Parent");
    }
}