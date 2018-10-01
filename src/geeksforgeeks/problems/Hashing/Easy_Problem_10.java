package geeksforgeeks.problems.Hashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find duplicates in a given array when elements are not limited to a range
 * Given an array of n integers. The task is to print the duplicates
 * in the given array. If there are no duplicates then print -1.
 *
 * Examples:
 *
 * Input : {2, 10, 100, 2, 10, 11}
 * Output : 2 10
 *
 * Input : {5, 40, 1, 40, 100000, 1, 5, 1}
 * Output : 5 40 1
 * Note:The duplicate elements can be printed in any order.
 *
 */
public class Easy_Problem_10 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int arr[] = {5, 40, 1, 40, 100000, 1, 5, 1};

        for(int i : arr) {
            if(!hashMap.containsKey(i)){
               hashMap.put(i, 1);
            }
            else if(hashMap.get(i) != -1){
                System.out.println(i);
                hashMap.put(i, -1);
            }
        }
    }
}
