package CodingNinja.AdvancedRecursion;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 7, 4, 8, 5 };
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(array, start, mid);
        sort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    void merge(int arr[], int start, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int size1 = mid - start + 1;
        int size2 = right - mid;

        /* Create temp arrays */
        int L[] = new int[size1];
        int R[] = new int[size2];

        /* Copy data to temp arrays */
        for (int i = 0; i < size1; ++i)
            L[i] = arr[start + i];
        for (int j = 0; j < size2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = start;
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}