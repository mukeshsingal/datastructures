package leetcode;

public class Problem_1295_Find_Numbers_with_Even_Number_of_Digits {
    
}

class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        
        for(int i : nums) {
            
            int count = 0;
            while(i > 0) {
                i = i/10;
                count++;
            }
            if(count % 2 ==0 ) {
                result++;
            }
        }
        return result;
    }
}