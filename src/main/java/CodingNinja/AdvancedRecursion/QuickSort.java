package CodingNinja.AdvancedRecursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();

        int[] arr = { 1, 4, 2, 5, 6, 0 };
        sort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int index = partition(array, start, end);

        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);

    }

    int partition(int arr[], int start, int end) {
        int pivot = arr[end];

        int i = (start - 1); // index of smaller element

        for (int j = start; j < end; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

}