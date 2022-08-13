package leetcode;

/*
* https://leetcode.com/problems/count-binary-substrings/
*
* */

public class Problem_696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {

        char[] arr = s.toCharArray();
        int result = 0;
        for(int i = 0; i < arr.length -1; i++) {
            int j = i + 1;
            int k = i;

            while(k >= 0 && j < arr.length && arr[k] == arr[i] && arr[j] == arr[i+1] && arr[k] != arr[j]){
                result++;
                k--;
                j++;
            }
        }
        return result;
    }
}
