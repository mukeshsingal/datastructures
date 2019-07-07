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
public class Problem_623_Add_One_Row_to_Tree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return addOneRow(root, v, d, 1);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d, int depth) {
        if(root == null) {
            return null;
        }
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        if(d-1 == depth) {
            addNodes(root, v);
            return root;
        }
        addOneRow(root.left, v,d,depth+1);
        addOneRow(root.right, v,d,depth+1);
        return root;
    }
    public void addNodes(TreeNode root, int v) {
        TreeNode node = new TreeNode(v);
        node.left = root.left;
        root.left = node;

        TreeNode node2 = new TreeNode(v);
        node2.right = root.right;
        root.right = node2;
    }
}