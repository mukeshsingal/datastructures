package leetcode;

public class Problem_258_Add_Digits {

    public int addDigits(int num) {
        return num - 9 * (int)(Math.floor((num-1)/9));
    }
}