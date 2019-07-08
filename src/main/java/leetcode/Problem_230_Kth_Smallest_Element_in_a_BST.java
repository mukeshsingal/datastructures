package leetcode;

public class Problem_230_Kth_Smallest_Element_in_a_BST {



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int x = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }

        int l = kthSmallest(root.left, k);
        if(l != 0 && x == k) {
            return l;
        }

        if(++x == k) {
            return root.val;
        }

        int r = kthSmallest(root.right, k);
        if(r != 0 && x == k) {
            return r;
        }

        return 0;
    }
}