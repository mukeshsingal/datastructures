package mustdo.Greedy;

/**
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a
 * single person, assuming that a person can only work on a single
 * activity at a time.
 * <p>
 * Example 1 : Consider the following 3 activities sorted by
 * by finish time.
 * start[]  =  {10, 12, 20};
 * finish[] =  {20, 25, 30};
 * <p>
 * A person can perform at most two activities. The maximum set of activities that can be executed is {0, 2} [ These are indexes in start[] and
 * finish[] ]
 *
 * <p>
 * Example 2 : Consider the following 6 activities
 * sorted by by finish time.
 * <p>
 * start[]  =  {1, 3, 0, 5, 8, 5};
 * finish[] =  {2, 4, 6, 7, 9, 9};
 * <p>
 * A person can perform at most four activities. The maximum set of
 * activities that can be executed is {0, 1, 3, 4}
 * [ These are indexes in start[] and finish[]]
 *
 *
 * Algorithm:
 *
 * Sort start[] and finish[] by Finish time of activity array
 * 1. Select first Activity
 * 2. For rest of activities,
 *      1. Select those activities
 *          where prev end time < next start time
 */
public class ActivitySelectionProblem {
    public static void printMaxActivities(int start[], int finish[]) {
        int i = 0;
        int prevIndex = 0;
        System.out.println(start[0] + " - " + finish[0]);
        for (int j = 1; j < start.length; j++) {
            if (finish[prevIndex] <= start[j]) {
                prevIndex = j;
                System.out.println(start[j] + " - " + finish[j]);
            }
        }
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

        /* Sort start and Finish Array based on finish[] sorted order.
        Here it is already Sorted */
        printMaxActivities(start, finish);
    }
}
