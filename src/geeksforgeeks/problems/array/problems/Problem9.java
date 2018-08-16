package geeksforgeeks.problems.array.problems;

public class Problem9 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray1(arr, 0, arr.length-1);
        printArray(arr);
    }

    /*Iterative*/
    public static void reverseArray1(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*Recursive*/
    public static void reverseArray(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }

    private static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + ", " );
        }
        System.out.println();
    }
}
