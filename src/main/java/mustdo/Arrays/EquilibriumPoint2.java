package mustdo.Arrays;

/**
 * Find first element which has all small element of lest and large elements on right
 * Algorithm:
 * element should be > largest element from the left
 * element should be < smallest element from the right
 */
public class EquilibriumPoint2 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 4, 19, 20};

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        //fill left array
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxElement)
                maxElement = arr[i];
            left[i] = maxElement;
        }

        //fill right array
        int minElement = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < minElement)
                minElement = arr[i];
            right[i] = minElement;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] >= left[i - 1] && arr[i] <= right[i + 1]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
