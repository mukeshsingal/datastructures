package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-a-number-in-minimum-steps/
public class FindANumberInMinimumSteps {

    public static void main(String[] args) {
        int number = 15;
        System.out.println(minStep(-6));
    }

    public static int minStep(int number){
        BinaryTree tree =  new BinaryTree();
        tree.root = new BinaryTree.Node(0,1);

        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            BinaryTree.Node node = queue.remove();
            if(node.key == number){
                return node.level;
            }
            else{
                queue.add(new BinaryTree.Node(node.key - node.level, node.level + 1));
                queue.add(new BinaryTree.Node(node.key + node.level, node.level + 1));
            }
        }
        return -1;
    }
}


class BinaryTree {
    Node root;
    static class Node {
        int key;
        int level;
        Node left;
        Node right;
        Node(int key, int level){
            this.key = key;
            this.level = level;
            left = null;
            right = null;
        }
    }
}