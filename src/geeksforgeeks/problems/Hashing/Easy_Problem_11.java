package geeksforgeeks.problems.Hashing;

import java.util.HashMap;

/**
 * Find top k (or most frequent) numbers in a stream
 *
 * Given an array of n numbers. Your task is to read numbers from
 * the array and keep at-most K numbers at the top (According to
 * their decreasing frequency) every time a new number is read.
 * We basically need to print top k numbers sorted by frequency
 * when input stream has included k distinct elements, else need
 * to print all distinct elements sorted by frequency.
 *
 * Examples:
 *
 * Input :  arr[] = {5, 2, 1, 3, 2}
 *              k = 4
 * Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5
 *
 * Input  : arr[] = {5, 2, 1, 3, 4}
 *              k = 4
 * Output : 5 2 5 1 2 5 1 2 3 5 1 2 3 4
 * Expected time complexity is O(n * k)
 * */
public class Easy_Problem_11 {
    public static void main(String[] args) {
        int arr[] = {5, 2, 1, 3, 2};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
                System.out.println(hashMap);
            }
            else {
                hashMap.put(arr[i], 1);
                System.out.println(hashMap);
            }
        }
    }
}
