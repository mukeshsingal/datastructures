package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_118_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i-1);
            List<Integer> current = new ArrayList<>();

            current.add(1);

            for (int j = 1; j < prev.size(); j++) {
                current.add(prev.get(j-1) + prev.get(j));
            }
            current.add(1);

            result.add(current);
        }
        return result;
    }
}