package leetcode;

import java.util.HashMap;



public class Problem_138_Copy_List_with_Random_Pointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        Node copyHead = null;
        Node referenceHead = null;
        
        // To maintain a reference to random pointer
        HashMap<Node, Node> map = new HashMap<>();
        
        Node node = head;
        
        while(node != null) {
            Node newNode = new Node(node.val);
            if(copyHead != null) {
                referenceHead.next = newNode;
                referenceHead = referenceHead.next;
            }
            else {
                copyHead = newNode;
                referenceHead = newNode;
            }
            map.put(node, newNode);
            node = node.next;
        }
        
        node = head;
        referenceHead = copyHead;
        
        //Iterate again and put the reference pointers again
        while(node != null) {
            referenceHead.random = map.get(node.random);
            referenceHead = node.next;
            referenceHead = referenceHead.next;
        }
        return copyHead;
    }
}
