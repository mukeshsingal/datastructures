package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_412_Fizz_Buzz {


    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();

        String fizz = "Fizz";
        String buzz = "Buzz";
        String both = "FizzBuzz";

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add(both);
            }
            else if(i % 3 == 0) {
                result.add(fizz);
            }
            else if(i % 5 == 0) {
                result.add(buzz);
            }
            else
                result.add(i + "");
        }
        return result;
    }
}