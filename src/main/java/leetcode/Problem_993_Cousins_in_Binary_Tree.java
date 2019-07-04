package leetcode;

public class Problem_993_Cousins_in_Binary_Tree {
    
    private int firstDepth = 0;
    private TreeNode firstParent = null;

    private int secondDepth = 0;
    private TreeNode secondParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root != null && root.val != x && root.val != y) {
            depth(root, x, y, 0);
        }
        if(firstDepth == secondDepth && firstParent != secondParent){
            return true;
        }
        return false;
    }

    private void depth(TreeNode root, int x, int y, int depth){
        if(root.left != null) {
            if(root.left.val == x) {
                firstDepth = depth + 1;
                firstParent = root;
            }
            else if(root.left.val == y) {
                secondDepth = depth + 1;
                secondParent = root;
            }
            depth(root.left, x, y, depth +1);
        }
        if(root.right != null) {
            if(root.right.val == x) {
                firstDepth = depth + 1;
                firstParent = root;
            }
            else if(root.right.val == y) {
                secondDepth = depth + 1;
                secondParent = root;
            }
            depth(root.right, x, y, depth +1);
        }
    }


}