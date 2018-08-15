package geeksforgeeks.problems.array.search;

/**
 * Find the Missing Number
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the
 * list. Write an efficient code to find the missing integer.
 */
public class Problem5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};

        // S(n) = n (n+1) / 2;
        int sumOfNumber = (8 * 9 )/ 2;

        for(int i : arr) {
            sumOfNumber -= i;
        }
        System.out.println(sumOfNumber);
    }
}
