package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class Problem_257_Binary_Tree_Paths {

    StringBuilder path = new StringBuilder();
    ArrayList<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) {
            return result;
        }

        if(root.left == null && root.right ==null) {
            int l = path.length();
            path.append(root.val);
            result.add(path.toString());
            path.delete(l, path.length());
        }

        int l = path.length();

        path.append(root.val + "->");

        binaryTreePaths(root.left);
        binaryTreePaths(root.right);

        path.delete(l, path.length());

        return result;
    }
}