package leetcode;


import java.util.ArrayList;
import java.util.List;

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

public class Problem_589_N_ary_Tree_Preorder_Traversal {

    public List<Integer> preorder(Node root) {
        List<Integer> preOrderList = new ArrayList<>();
        preorder(root, preOrderList);
        return preOrderList;
    }

    public void preorder(Node root, List<Integer> preOrderList) {
        if(root == null) {
            return;
        }
        preOrderList.add(root.val);
        if(root.children == null) {
            return;
        }
        for(Node node: root.children) {
            preorder(node, preOrderList);
        }

    }
}

