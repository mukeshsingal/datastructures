package leetcode;

public class Problem_11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while(left < right) {
            int waterUnit = Math.min(height[left], height[right]) * (right - left);
            if(max < waterUnit) {
                max = waterUnit;
            }
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;

    }
}
