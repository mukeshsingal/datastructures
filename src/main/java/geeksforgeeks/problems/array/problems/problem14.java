package geeksforgeeks.problems.array.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort elements by frequency
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 * Examples:
 * Input: arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 * Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */

public class problem14 {
    public static void main(String[] args) {
        int array[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        sortArray(array);
        int[][] x = construct(array);

        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer itemIdOne = o1[2];
                Integer itemIdTwo = o2[2];
                // sort on item id
                return itemIdOne.compareTo(itemIdTwo);
            }
        });

        x[0][1] = 1;

        for (int i = 1; i < x.length; i++) {
            /*If element equals to previous element, then set previous  element to
             * -1 and update count of current element by 1*/
            if (x[i][2] == x[i - 1][2]) {
                x[i][1] = x[i - 1][1];
                x[i - 1][1] = -1;
            }
            /*else update count by one.*/
            x[i][1]++;
        }

        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer itemIdOne = o1[1];
                Integer itemIdOneIndex = o1[0];
                Integer itemIdTwo = o2[1];
                Integer itemIdTwoIndex = o2[0];

                if (itemIdOne != itemIdTwo) return itemIdOne.compareTo(itemIdTwo);
                else return itemIdOneIndex.compareTo(itemIdTwoIndex);

            }
        });


        for (int i = x.length - 1, index = 0; i >= 0; i--)
            if (x[i][1] != -1)
                for (int j = 0; j < x[i][1]; j++)
                    array[index++] = x[i][2];

        for (int a : array) {
            System.out.print(" " + a);
        }
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static int[][] construct(int[] array) {
        int[][] matrix = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            matrix[i] = new int[]{i, 0, array[i]};
        }
        return matrix;
    }
}
