package mustdo.Tree;

import java.util.*;


public class BottomView extends TreeUtil{
    public static class Node {
        int data;
        int hd;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.hd = Integer.MAX_VALUE;
        }

    }


    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.right.left = new Node(27);
        root.left.right.right = new Node(14);

        System.out.println((new BottomView()).bottomView(root));

    }


    public ArrayList <Integer> bottomView(Node root) {

        ArrayList<Integer> array = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.hd = 0;
        queue.add(root);


        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                map.put(node.hd, node.data);
                if (node.left != null) {
                    node.left.hd = node.hd - 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.hd = node.hd + 1;
                    queue.add(node.right);
                }
            }

        }

        for (Map.Entry<Integer, Integer> e :map.entrySet()) {
            array.add(e.getValue());
        }

        return array;
    }




}
