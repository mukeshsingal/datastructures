package leetcode;

public class Problem_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return DFS(nums, 0, nums.length - 1);
    }

    private TreeNode DFS(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (low <= mid - 1)
            root.left = DFS(nums, low, mid - 1);
        if (mid + 1 <= high)
            root.right = DFS(nums, mid + 1, high);
        return root;
    }
}