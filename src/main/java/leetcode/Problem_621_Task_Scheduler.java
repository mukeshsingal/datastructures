package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where different letters represent different tasks. Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class Problem_621_Task_Scheduler {

    /**
     *
     * Idea: I max heap take task occuring most of time as they will be scheduled more number of times.
     * So we will schedule task from priority queue until the relax interval is over. Once done will we push
     * the popped jobs by decrementing counter by 1.  
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks) {
            map[c - 'A']++;
        }

        //Init priority Queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());

        //Add non zero items to priority queue;
        for(int f: map) {
            if(f > 0)
                queue.add(f);
        }
        int time = 0;

        while(!queue.isEmpty()) {
            int i =0;

            //Init temp list
            List<Integer> temp = new ArrayList<>();
            //Run for relax time

            while(i <= n) {
                //Pop max items n times and keep them into the list
                if(!queue.isEmpty()) {
                    if(queue.peek() > 1)
                        temp.add(queue.poll() -1);
                    else
                        queue.poll();
                }

                time++;
                i++;

                //this case comes only at the end while queue is empty not
                if(queue.isEmpty() && temp.size() == 0)
                    break;
            }
            for(int l: temp) {
                queue.add(l);
            }
        }
        return time;
    }
}