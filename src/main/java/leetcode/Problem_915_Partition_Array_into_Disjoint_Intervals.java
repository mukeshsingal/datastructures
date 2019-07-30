package leetcode;

public class Problem_915_Partition_Array_into_Disjoint_Intervals {

    public int partitionDisjoint(int[] A) {
        int[] small = new int[A.length];
        int result = 1;
        int min = A[A.length -1];

        small[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            small[i] = A[i] < small[i-1] ? small[i-1] : A[i];
        }

        for(int i = A.length - 1; i >=1; i--) {
            if(min > A[i]) min = A[i];

            if(A[i] >= small[i-1] && small[i-1] <= min) {
                result = i;
            }
        }
        return result;
    }
}