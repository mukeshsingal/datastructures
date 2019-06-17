package leetcode;

class Problem_908_Smallest_Range_I {
    public int smallestRangeI(int[] A, int K) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: A) {
            if(i < min) {
                min = i;
            }
            if(i > max) {
                max = i;
            }
        }

        int avg = (min + max) / 2;

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > avg) {
                A[i] = A[i] - K > avg ? A[i] - K : avg;
            }
            else {
                A[i] = A[i] + K < avg ? A[i] + K : avg;
            }
            if(A[i] < min) {
                min  = A[i];
            }
            if(A[i] > max) {
                max  = A[i];
            }
        }

        return max - min;
    }
}