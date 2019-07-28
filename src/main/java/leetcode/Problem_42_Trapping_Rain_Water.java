package leetcode;

public class Problem_42_Trapping_Rain_Water {

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];

        //left to right
        leftToRight[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftToRight[i] = Math.max(height[i], leftToRight[i-1]);
        }

        //right to left
        rightToLeft[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            rightToLeft[i] = Math.max(height[i], rightToLeft[i+1]);
        }

        int max = 0;
        for(int i = 0; i < height.length; i++) {
            max += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return max;
    }
}


