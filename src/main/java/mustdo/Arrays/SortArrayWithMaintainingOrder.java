package mustdo.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayWithMaintainingOrder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1, 2};
        int order[] = {2, 4, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(order));
        sortArray(arr, order);
    }

    private static void sortArray(int[] arr, int[] order) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int count = 0;
        for (int i : order) {
            if (map.containsKey(i)) {
                int times = map.get(i);
                while (times != 0 && map.get(i) != 0) {
                    arr[count++] = i;
                    times--;
                }
                map.put(i, 0);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int times = e.getValue();
            while (times != 0) {
                arr[count++] = e.getKey();
                times--;
            }
            map.put(e.getKey(), 0);
        }
        System.out.println(Arrays.toString(arr));
    }
}
