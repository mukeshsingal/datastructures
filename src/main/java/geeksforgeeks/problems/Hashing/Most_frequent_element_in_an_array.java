package geeksforgeeks.problems.Hashing;

import java.util.HashMap;

public class Most_frequent_element_in_an_array {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 50, 30, 20, 50, 60};

        System.out.println("Most frequent number of " + getMostFrequentNumber(arr));
    }

    public static int getMostFrequentNumber(int[] arr) {
        if (arr.length == 0)
            return -1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int maxNumber = arr[0];
        int maxCount = 1;
        int tempCount;
        for (int i : arr) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                tempCount = hashMap.get(i) + 1;
                hashMap.put(i, tempCount);
                if (maxCount < tempCount)
                    maxNumber = i;
            }
        }
        return maxNumber;
    }
}