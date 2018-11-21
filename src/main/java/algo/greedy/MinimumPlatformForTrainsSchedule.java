package algo.greedy;

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that
 * no train waits. We are given two arrays which represent arrival and departure
 * times of trains that stop.
 * <p>
 * Algorithms:
 * 1. Sort arr and dep array individually
 * 2. then use merge function of merge sort to process both the arrays
 * 3. Minimum number of platform = Maximum no of train present any point of time
 *    which means count on arrival and decrease on departure
 */
public class MinimumPlatformForTrainsSchedule {

    public static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int trainOnPlatform = 0, result = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                trainOnPlatform++;
                i++;
                if (trainOnPlatform > result)
                    result = trainOnPlatform;
            } else {
                trainOnPlatform--;
                j++;
            }
        }

        return result;
    }
        public static void main (String[] args){
            int arr[] = {900, 940, 950, 1100, 1500, 1800};
            int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
            int n = arr.length;
            System.out.println("Minimum Number of Platforms Required = "
                    + findPlatform(arr, dep, n));
        }

    }
