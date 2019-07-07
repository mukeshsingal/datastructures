package leetcode;


// Definition for a Node2.
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val,Node2 _left,Node2 _right,Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Problem_117_Populating_Next_Right_Pointers_in_Each_Node2_II {
    
    public Node2 connect(Node2 root) {
        return connect(root, null);
    }
    
    public Node2 connect(Node2 root, Node2 parent) {
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
    
    public Node2 getNext(Node2 root) {
        while(root != null) {
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
            root = root.next;
        }
        return null;
    }
}


