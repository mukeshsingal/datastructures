package geeksforgeeks.problems.array.search;

public class Problem3 {
    //Find the Number Occurring Odd Number of Times
    //Given an array of positive integers. All numbers occur even number of times except one number which
    // occurs odd number of times. Find the
    //number in O(n) time & constant space.

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 4, 2, 4, 4, 2, 4, 4};
        solution1(array);
    }
    public static void solution1(int[] array) {
        int oddNumber =0;

        for(int i : array) {
            oddNumber = oddNumber ^ i;
        }
        System.out.println(oddNumber);
    }
}
