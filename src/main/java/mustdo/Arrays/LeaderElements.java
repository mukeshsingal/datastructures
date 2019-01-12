package mustdo.Arrays;

public class LeaderElements {
    public static void main(String[] args) {
        int[] arr = { 51, 10, 22, 9, 33, 21, 50, 41};
        //int[] arr = {3, 10, 2, 1, 20};
        //int[] arr = {3, 1};
        //int[] arr = {50, 3, 10, 7, 40, 80};

        findLeaders(arr);
    }

    private static void findLeaders(int[] arr) {
        int maxElement = arr[arr.length-1];
        System.out.println(maxElement);
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i] > maxElement) {
                System.out.println(arr[i]);
                maxElement = arr[i];
            }
        }
    }
}
