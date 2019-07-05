package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_590_N_ary_Tree_Postorder_Traversal {


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


    public List<Integer> postorder(Node root) {
        List<Integer> postOrderList = new ArrayList<>();
        postorder(root, postOrderList);
        return postOrderList;
    }

    public void postorder(Node root, List<Integer> postOrderList) {
        if(root == null) {
            return;
        }

        if(root.children == null) {
            return;
        }
        for(Node node: root.children) {
            postorder(node, postOrderList);
        }
        postOrderList.add(root.val);

    }
}

