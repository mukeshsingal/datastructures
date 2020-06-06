package geeksforgeeks.problems.dynamic_programming;

public class Problem_1_UglyNumber {

    public static void main(String[] args) {
        System.out.println(findUgly(15));
    }

    private static int findUgly(int n) {
        int ugly[] = new int[n];

        int i_2 = 0;
        int i_3 = 0;
        int i_5 = 0;

        int next_i_2 = 2;
        int next_i_3 = 3;
        int next_i_5 = 5;

        int count = 1;

        int min = 0;
        while (count < n) {

            min = Math.min(next_i_2, Math.min(next_i_3, next_i_5));
            ugly[count] = min;

            if (next_i_2 == min) {
                i_2++;
                next_i_2 = ugly[i_2] * 2;
            }
            if (next_i_3 == min) {
                i_3++;
                next_i_3 = ugly[i_3] * 3;
            }
            if (next_i_5 == min) {
                i_5++;
                next_i_5 = ugly[i_5] * 5;
            }
            count++;
        }
        return min;
    }

}