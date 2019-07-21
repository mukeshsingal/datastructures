package leetcode;

public class Problem_5133_Maximum_of_Absolute_Value_Expression {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr1.length; i++) {
            int localMax = Integer.MIN_VALUE;
            for(int j = i; j < arr1.length; j++) {
                int x = Math.abs(i-j) + Math.abs(arr1[i]-arr1[j]) + Math.abs(arr2[i]-arr2[j]);
                if(x > localMax) {
                    localMax = x;
                }
            }
            if(localMax > max) {
                max = localMax;
            }
        }
        return max;
    }
}