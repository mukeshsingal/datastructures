package leetcode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Problem_654_Maximum_Binary_Tree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
        if(i == j) {
            return new TreeNode(nums[i]);
        }
        if(i > j) {
            return null;
        }
        int maxIndex = findMaxIndex(nums, i, j);

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, i, maxIndex-1);
        root.right = constructMaximumBinaryTree(nums, maxIndex+1, j);
        return root;
    }

    private int findMaxIndex(int[] arr, int x, int y) {
        int maxVal = arr[x];
        int maxIndex = x;
        for(int i = x; i <=y; i++) {
            if(arr[i] > maxVal) {
                maxVal = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}