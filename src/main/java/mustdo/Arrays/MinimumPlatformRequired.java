package mustdo.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Algorithm is
 * Number platform required = max number of buses present in bus stand at a time
 * Create a List with all arrival and departure timings
 * Create a counter which inc on arrival and dec on departure of bus
 * so Maximum value of counter at any time will be number of platform required
 */
public class MinimumPlatformRequired {
    enum Type {
        arrival, deptarture
    }

    static class Interval {
        int time;
        Type type;

        public Interval(int arrivalTime, Type type) {
            time = arrivalTime;
            this.type = type;
        }

        @Override
        public String toString() {
            return this.time + " " + this.type.toString();
        }
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        List<Interval> busTimings = new ArrayList<>();

        for (int i = 0; i < dep.length; i++) {
            busTimings.add(new Interval(arr[i], Type.arrival));
            busTimings.add(new Interval(dep[i], Type.deptarture));
        }

        int count = 0;
        int maxCount = 0;

        busTimings.sort(Comparator.comparingInt(value -> value.time));

        for (Interval b : busTimings) {
            System.out.println(b);
            if (b.type == Type.arrival) {
                count++;
                if (count > maxCount)
                    maxCount = count;
            } else
                count--;
        }
        System.out.println("Number of platform required :  " + maxCount);
    }
}
