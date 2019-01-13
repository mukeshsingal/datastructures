package mustdo.Arrays;

/**
 * Algorithm
 * All elements before the required have first occurrence at even index (0, 2, ..)
 * and next occurrence at odd index (1, 3, …). And all elements after the required
 * element have first occurrence at odd index and next occurrence at even index.
 * <p>
 * 1) Find the middle index, say ‘mid’.
 * 2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1].
 * If both are same, then the required element after ‘mid’ else before mid.
 * <p>
 * 3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are same,
 * then the required element after ‘mid’ else before mid.
 * <p>
 * Below is the implementation based on above idea.
 */
public class FindElementWhichAppearOnceInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
        System.out.println("Element is ");
        findElement(arr, 0, arr.length);
    }

    private static void findElement(int[] arr, int low, int high) {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is " + arr[low]);
            return;
        }
        int mid = (low + high) / 2;

        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
                findElement(arr, mid + 2, high);
            else
                findElement(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                findElement(arr, mid + 1, high);
            else
                findElement(arr, low, mid - 1);
        }
    }

}
