package leetcode;

import java.util.ArrayList;

//https://leetcode.com/problems/baseball-game/
public class Problem_682_Baseball_Game {
    public int calPoints(String[] ops) {
        ArrayList<Integer> results = new ArrayList<>();

        for(String op: ops) {
            if(op.equals("C")) {
                results.remove(results.size() - 1);
            }
            else if(op.equals("D")) {
                results.add(results.get(results.size() - 1) * 2);
            }
            else if(op.equals("+")) {
                results.add(results.get(results.size() - 1) + results.get(results.size() - 2));
            }
            else {
                results.add(Integer.valueOf(op));
            }
        }
        int result = 0;
        for(int i : results) result += i;

        return result;
    }
}
