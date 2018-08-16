package geeksforgeeks.problems.array.problems;

/*Program for array rotation
Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.*/

//left and right rotate array by d positions using reverse function

//Time complexity = T(N)
public class Problem10 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        printArray(arr);
        rightRotate(arr, 6 );
        printArray(arr);
    }

    public static void leftRotate(int[] arr, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d , arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    public static void rightRotate(int[] arr, int d) {
        reverse(arr, 0, arr.length-d-1);
        reverse(arr, arr.length-d, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    public static void reverse(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
