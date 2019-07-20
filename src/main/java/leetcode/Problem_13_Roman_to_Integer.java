package leetcode;

public class Problem_13_Roman_to_Integer {

    public int romanToInt(String s) {
        int[] arr = new int[26];
        arr['I' - 'A'] = 1;
        arr['V' - 'A'] = 5;
        arr['X' - 'A'] = 10;
        arr['L' - 'A'] = 50;
        arr['C' - 'A'] = 100;
        arr['D' - 'A'] = 500;
        arr['M' - 'A'] = 1000;

        int sum = 0;
        int lastNum = 0;
        for(char c: s.toCharArray()) {
            if(arr[c - 'A'] > lastNum) {
                sum = sum + arr[c - 'A'] - (2 * lastNum);
                lastNum = arr[c - 'A'];
                continue;
            }
            sum = sum + arr[c - 'A'];
            lastNum = arr[c - 'A'];
        }
        return sum;
    }
}