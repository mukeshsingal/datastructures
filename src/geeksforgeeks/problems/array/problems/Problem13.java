package geeksforgeeks.problems.array.problems;

/**
 * Leaders in an array
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side. And the rightmost
 * element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class Problem13 {

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};

        int max = arr[arr.length-1];

        System.out.println(arr[arr.length-1]);

        for (int i = arr.length - 2; i > 0; i--) {
            if(arr[i] > max) {
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
    }
}
