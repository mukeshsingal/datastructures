package geeksforgeeks.problems.dynamic_programming;

import java.util.Arrays;

public class Problem_3_Catalan {
    public static void main(String[] args) {
        System.out.println("Catalan " + catalanBottomUp(1));        
        System.out.println("Catalan " + catalanBottomUp(2));        
        System.out.println("Catalan " + catalanBottomUp(3));        
        System.out.println("Catalan " + catalanBottomUp(4));        
  
        // System.out.println("Catalan " + catalanMemo(1, new int[2]));
        // System.out.println("Catalan " + catalanMemo(2, new int[3]));
        // System.out.println("Catalan " + catalanMemo(3, new int[4]));
        // System.out.println("Catalan " + catalanMemo(4, new int[5]));
    }

    public static int catalan(int number) {
        if(number == 0) {
            return 1;
        }

        int catalanNumber = 0;

        for(int i = 0; i < number; i++) {
            catalanNumber += catalan(i)* catalan(number-i-1);
        }
        return catalanNumber;
    }

    public static int catalanMemo(int number, int[] array) {
        if(number == 0) {
            return 1;
        }
        if(array[number] != 0) {
            
            return array[number];
        }

        int catalanNumber = 0;

        for(int i = 0; i < number; i++) {
            catalanNumber += catalanMemo(i, array)* catalanMemo(number-i-1, array);
        }
        array[number] = catalanNumber;
        return catalanNumber;
    }

    public static int catalanBottomUp(int number) {
        int[] array = new int[number+1];
        array[0] = 1;
        
        for(int i = 1; i <= number; i++) {
            int catalanNumber = 0;

            for(int j = 0; j < i; j++) {
                catalanNumber += array[j]*array[i-j-1];
            }
            array[i] = catalanNumber;
        }
        
        return array[number];
    }
}