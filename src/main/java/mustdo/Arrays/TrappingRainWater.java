package mustdo.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        //int[] blockHeights = {6, 9, 9};
        int[] blockHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int waterTrapper = getWaterTrapped(blockHeights);
        System.out.println("Trapped water unit : " + waterTrapper);
    }

    public static int getWaterTrapped(int[] arr) {
        int[] leftMaxHeight = new int[arr.length];
        int[] rightMaxHeight = new int[arr.length];

        leftMaxHeight[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], arr[i]);
        }

        rightMaxHeight[rightMaxHeight.length - 1] = arr[arr.length - 1];
        for (int i = rightMaxHeight.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], arr[i]);
        }

        //calculate trapper rain water
        int trappedWaterUnit = 0;
        for (int i = 0; i < arr.length; i++) {
            trappedWaterUnit += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - arr[i];
        }

        return trappedWaterUnit;
    }
}
