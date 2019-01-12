package mustdo.Arrays;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6};
        int k = 7;
        System.out.println("Kth Smallest Number : " + getMissingNumber(arr, k));
    }

    public static int getMissingNumber(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int x : arr) {
            priorityQueue.add(x);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
