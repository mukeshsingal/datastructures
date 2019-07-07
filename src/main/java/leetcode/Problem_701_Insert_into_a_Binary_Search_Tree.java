package leetcode;

public class Problem_701_Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);
        if(root == null)
            return newNode;

        TreeNode node = root;
        while(node != null) {
            if(node.val < val) {
                if(node.right == null) {
                    node.right = newNode;
                    break;
                }
                node = node.right;
            }
            else if(node.val > val) {
                if(node.left == null) {
                    node.left = newNode;
                    break;
                }
                node = node.left;
            }
        }
        return root;
    }
}