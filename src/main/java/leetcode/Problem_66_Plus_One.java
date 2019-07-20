package leetcode;

public class Problem_66_Plus_One {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int size = digits.length-1;

        while(size >= 0) {
            int x = digits[size] + 1;
            if(x < 10) {
                digits[size] = digits[size] + 1;
                carry = 0;
                break;
            }
            digits[size] = x%10;
            size--;
            carry = 1;
        }

        if(carry == 1) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            for(int i =0; i < digits.length; i++) {
                arr[i+1] = digits[i];
            }
            return arr;
        }
        return digits;
    }
}
