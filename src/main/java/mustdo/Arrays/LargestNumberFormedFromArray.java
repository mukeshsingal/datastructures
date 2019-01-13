package mustdo.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LargestNumberFormedFromArray {
    public static void main(String[] args) {
        int[] arr = {54, 546, 548, 60};
        List<String> numbers = new ArrayList<>();
        for (int i : arr) {
            numbers.add(String.valueOf(i));
        }

        numbers.sort((o1, o2) -> {
            String first = o1 + o2;
            String second = o2 + o1;
            return Integer.compare(Integer.valueOf(second), Integer.valueOf(first));
        });
        String maxNumber = "";
        for (String x :
                numbers) {
            maxNumber += x;
        }
        System.out.println(maxNumber);
    }

}
