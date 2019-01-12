package mustdo.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumOfSubArrayWindowsSizeK {
    public static void main(String[] args) {

        int[] arr = {50, 3, 10, 7, 40, 80};

        int k = 3;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k - 1; i++) {
            pQueue.add(arr[i]);
        }
        for (int i = k - 1; i < arr.length; i++) {
            pQueue.add(arr[i]);
            System.out.println(pQueue.peek());
            pQueue.remove(arr[i - k + 1]);
        }
    }
}
