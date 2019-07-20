package leetcode;

public class Problem_9_Palindrome_Number {

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int arr[] = new int[15];
        int size = 0;
        while( x!=0 ) {
            arr[size] = x%10;
            x = x/10;
            size++;
        }
        int i = 0;
        int j = size-1;
        while(i < j) {
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}