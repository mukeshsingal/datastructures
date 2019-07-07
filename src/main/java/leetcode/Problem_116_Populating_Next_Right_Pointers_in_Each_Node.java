package leetcode;


// Definition for a Node3.
class Node3 {
    public int val;
    public Node3 left;
    public Node3 right;
    public Node3 next;

    public Node3() {}

    public Node3(int _val,Node3 _left,Node3 _right,Node3 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Problem_116_Populating_Next_Right_Pointers_in_Each_Node {

    public Node3 connect(Node3 root) {
        //print(root);
        return connect(root, null);
        //print(root);
        //return root;
    }

    public void print(Node3 root) {
        if(root==null) {
            return;
        }
        String left = root.left == null ? "null" : root.left.val + "";
        String right = root.right == null ? "null" : root.right.val + "";

        System.out.println(root.val + " ( " +  left +", " + right + ") -> " + (root.next != null ? root.next.val : "null"));
        print(root.left);
        print(root.right);
    }

    public Node3 connect(Node3 root, Node3 parent) {
        if(root == null){
            return null;
        }
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNext(root.next);
        }
        else if(root.right == null && root.left != null) {
            root.left.next = getNext(root.next);
        }
        else if(root.right != null && root.left == null) {
            root.right.next = getNext(root.next);
        }

        connect(root.right, root);
        connect(root.left, root);

        return root;
    }
    public Node3 getNext(Node3 root) {
        while(root != null) {
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
            root = root.next;
        }
        return null;
    }
}
