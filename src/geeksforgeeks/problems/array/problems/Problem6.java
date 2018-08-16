package geeksforgeeks.problems.array.problems;

/**
 * Search an element in a sorted and rotated array
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n)
 * time.
 */
public class Problem6 {
    public static void main(String[] args) {
        int[] arr = {4, 9, 12, 15, 17, 18, 2};

        int[] expected = {0, 1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Key = " + arr[i] +
                    " Expected= " + expected[i] + " Actual= " +
                    pivotedBinarySearch(arr, arr.length, arr[i]));
        }
    }

    public static int findPivot(int[] arr, int left, int right) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (mid < right && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > left && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        }
        if (arr[left] >= arr[mid]) {
            return findPivot(arr, left, mid - 1);
        }

        return findPivot(arr, mid + 1, right);
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (right < left) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return binarySearch(arr, left, mid - 1, key);
        }
        return binarySearch(arr, mid + 1, right, key);
    }

    public static int pivotedBinarySearch(int arr[], int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);
        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
        // If we found a pivot, then first compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }
}
