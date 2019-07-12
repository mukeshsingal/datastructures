package companies.amazon.DynmaicProgramming;

//https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
public class CountBitsFromNumbers {
    public static void main(String[] args) {
        System.out.println(getSetBits(3));
    }
    public static int getSetBits(int num) {
        int[] arr = new int[num+1];
        if(num == 1)
            return 1;
        if(num == 2)
            return 2;

        arr[1] = 1;
        arr[2] = 1;

        int sum = 2;
        for(int i = 3; i <= num; i++) {
            arr[i] =  i % 2 == 0 ? arr[i/2] : arr[i/2] + 1;
            sum += arr[i];
        }
        return sum;
    }

}
