package algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job
 * takes single unit of time, so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 *
 * Algorithm:
 * 1. Sort all the jobs in decreasing order of profit
 * 2. Create list of jobs done and add first element
 * 3. For each n-1 jobs do the following
 *      a. Idea is to schedule job as late as possible.
 *      b. To do that we are will put that job at a index less than or equal to its deadline.
 *      c. To schedule a job start seach for empty index for deadline to beginning
 *      for empty place. If empty place is not found means, job cannot be scheduled
 **/
public class JobSequencingProblem {


    static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        @Override
        public int compareTo(Job otherJob) {
            return otherJob.profit - this.profit;
        }

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        JobSequencingProblem jobSequencing = new JobSequencingProblem();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        Collections.sort(jobs);

        for (Job job : jobs) {
            System.out.println(job.id + " - " + job.profit);
        }
        jobSequencing.printJobSequence(jobs, jobs.size());

    }

    private void printJobSequence(ArrayList<Job> jobs, int size) {
        Boolean[] slots = new Boolean[size];
        Arrays.fill(slots, false);

        int result[] = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
                if (!slots[j]) {
                    result[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }

        int totalProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (slots[i]) {
                totalProfit += jobs.get(result[i]).profit;
                System.out.println(" -> " + jobs.get(result[i]).id);
            }
        }
        System.out.println("\nTotal profit is " + totalProfit);
    }
}
