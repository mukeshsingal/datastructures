package leetcode;

public class Problem_911_Online_Election {


    int[] result;
    int[] count;
    int[] arr;
    public Problem_911_Online_Election(int[] persons, int[] times) {
        this.arr = times;
        int maxCount = -1;
        int maxPerson = -1;

        result = new int[persons.length];
        count = new int[persons.length+1];

        for(int i = 0; i < persons.length; i++) {
            count[persons[i]]++;
            if(maxCount <= count[persons[i]]) {
                maxCount = count[persons[i]];
                maxPerson = persons[i];
            }
            result[i] = maxPerson;
        }
    }

    public int q(int t) {
        int index = findClosest(t);
        return result[index];
    }

    public int findClosest(int target) {
        int n = arr.length;

        if (target <= arr[0])
            return 0;
        if (target >= arr[n - 1])
            return n - 1;

        int i = 0, j = n, mid = 0;

        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target)
                return mid;

            if (target < arr[mid]) {

                if (mid > 0 && target > arr[mid - 1])
                    return mid - 1;

                j = mid;
            }
            else {
                if (mid < n-1 && target < arr[mid + 1])
                    return mid;
                i = mid + 1;
            }
        }

        return mid;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */