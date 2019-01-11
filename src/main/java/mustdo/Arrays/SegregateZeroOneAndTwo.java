package mustdo.Arrays;

import java.util.Arrays;

/**
 * Segregate zero, one and two in array
 * Algorithm:
 * traverse array using three pointer low, high and curr
 * if curr point to zero then swap with low and increment low
 * if curr point to two then swap with high and decrement high
 * if curr point to one then increment current pointer
 */
public class SegregateZeroOneAndTwo {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 0, 2, 1, 1, 2, 0};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int lowIndex, highIndex, currentIndex;
        lowIndex = 0;
        highIndex = arr.length - 1;
        currentIndex = 0;
        while (currentIndex < highIndex) {
            switch (arr[currentIndex]) {
                case 0:
                    int temp = arr[lowIndex];
                    arr[lowIndex] = arr[currentIndex];
                    arr[currentIndex] = temp;
                    lowIndex++;
                    currentIndex++;
                    break;
                case 1:
                    currentIndex++;
                    break;
                case 2:
                    int temp2 = arr[highIndex];
                    arr[highIndex] = arr[currentIndex];
                    arr[currentIndex] = temp2;
                    highIndex--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
