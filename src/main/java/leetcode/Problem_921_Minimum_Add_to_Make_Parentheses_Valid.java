package leetcode;

public class Problem_921_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String S) {
        char[] arr = S.toCharArray();
        
        int ans = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                count++;
            }
            else {
                if(count == 0) {
                    ans++;
                }
                else {
                    count--;
                }
            }
        }
        
        for(int i = arr.length-1; i>=0; i--) {
            if(arr[i] == '(' && count != 0) {
                ans++;
                count--;
            }
        }
        return ans;
    }
}