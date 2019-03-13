package CodingNinja.Greedy;

import java.util.*;
import java.io.*;

public class ActivitySelectionProblem {

    static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String toString() {
            return String.valueOf(this.endTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().trim().split(" ");
            activities.add(new Activity(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
        }

        Collections.sort(activities, (Activity e1, Activity e2) -> e1.endTime < e2.endTime ? -1 : 1);

        int count = 1;
        int prev = 0;

        for (int i = 1; i < size; i++) {
            if (activities.get(prev).endTime <= activities.get(i).startTime) {
                prev = i;
                count++;
            }
        }

        System.out.println(count);

    }
}