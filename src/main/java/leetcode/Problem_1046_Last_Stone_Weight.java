package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_1046_Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : stones) {
            pQueue.add(i);
        }
        while(pQueue.size() > 1) {
            int stone1 = pQueue.remove();
            int stone2 = pQueue.remove();
            if(stone1 != stone2) {
                pQueue.add(stone1-stone2);
            }
        }
        return pQueue.size() == 0 ? 0 : pQueue.remove();
    }
}