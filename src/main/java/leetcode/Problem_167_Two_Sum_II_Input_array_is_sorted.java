package leetcode;

public class Problem_167_Two_Sum_II_Input_array_is_sorted {

    public int[] twoSum(int[] n, int t) {
        int i = 0;
        int j = n.length-1;
        while(i < j) {
            if(n[i] + n[j] > t) {
                j--;
            }
            else if(n[i] + n[j] < t) {
                i++;
            }
            else {
                return new int[] {i+1, j+1};
            }
        }
        return n;
    }
}