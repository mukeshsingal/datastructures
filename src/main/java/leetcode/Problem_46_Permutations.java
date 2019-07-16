package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_46_Permutations {

    ArrayList<List<Integer>> integer = new ArrayList<>();
    ArrayList<Integer> intList = new ArrayList<Integer>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length-1);
        return integer;
    }

    public void permute(int[] arr, int l, int r) {
        if (l == r) {
            for (int i : arr){
                intList.add(i);
            }
            integer.add((ArrayList<Integer>)intList.clone());
            intList.clear();
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(arr, l,i);
            permute(arr, l+1, r);
            swap(arr,l,i);
        }

    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}