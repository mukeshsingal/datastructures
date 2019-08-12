package leetcode;

public class Problem_575_Distribute_Candies {

    public int distributeCandies(int[] candies) {
        int[] arr = new int[200001];
        int kindCount = 0;
        for(int i: candies) {
            if(arr[i + 100000] != 1) {
                kindCount++;
            }
            arr[i + 100000] = 1;
        }
        return kindCount > candies.length/2 ? candies.length /2 : kindCount;
    }
}