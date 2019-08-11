package leetcode;

public class Problem_821_Shortest_Distance_to_a_Character {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];

        int i = 0, nextIndex = 0, lastIndex = 0;
        boolean first = true;

        while(nextIndex < S.length()) {
            if(S.charAt(nextIndex) == C) {
                while(i != nextIndex) {
                    result[i] = first ? nextIndex - i : Math.min(nextIndex - i, i - lastIndex);
                    i++;
                }
                first = false;
                lastIndex = nextIndex;
            }
            nextIndex++;
        }
        while(i < S.length()) {
            result[i] = i - lastIndex;
            i++;
        }
        return result;
    }

}