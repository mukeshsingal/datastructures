package leetcode;

public class Problem_559_Maximum_Depth_of_N_ary_Tree {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int result = 0;
        for(Node child: root.children) {
            result = Math.max(result, maxDepth(child));
        }
        return 1 + result;
    }
}
