package leetcode;

public class Problem_1051_Height_Checker {

    public int heightChecker(int[] heights) {
        int[] counts = new int[101];

        for(int i : heights) {
            counts[i]++;
        }

        int result = 0;
        int index = 0;
        for(int i = 0; i < heights.length; i++) {
            while(counts[index] == 0) {
                index++;
            }

            if(index != heights[i]) {
                result++;
            }

            counts[index]--;
        }

        return result;
    }
}