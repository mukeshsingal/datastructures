package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_257_Binary_Tree_Paths {

    StringBuilder b = new StringBuilder();
    ArrayList<String> strings = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) {
            return strings;
        }

        if(root.left == null && root.right ==null) {
            int l = b.length();
            b.append(root.val);
            strings.add(b.toString());
            b.delete(l, b.length());
        }

        int l = b.length();
        b.append(root.val + "->");

        binaryTreePaths(root.left);
        binaryTreePaths(root.right);

        b.delete(l, b.length());
        return strings;
    }
}