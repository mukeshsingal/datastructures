package geeksforgeeks.problems.array.search;

import java.util.HashMap;
import java.util.Map;

/**
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element)
 * <p>
 * I/P : 3 3 4 2 4 4 2 4 4
 * O/P : 4
 * I/P : 3 3 4 2 4 4 2 4
 * O/P : NONE
 */

/*TODO: Solve this using BST*/

    
public class Problem2 {
    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        solution1(array);
    }

    public static void solution1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int key = 0;
        int value = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > value) {
                key = entry.getKey();
                value = entry.getValue();
            }
        }
        if (value <= arr.length / 2) {
            System.out.println("NONE");
        } else {
            System.out.println("Key " + key);
        }
    }

    public static void solution2(int[] arr) {

    }
}

