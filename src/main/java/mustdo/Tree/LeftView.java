package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView extends TreeUtil {

    void levelOrderTraversal(Node root) {

        if(root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int noOfElementsInCurrentLevel = queue.size();
            System.out.println(queue.peek());

            for(int i = 0; i < noOfElementsInCurrentLevel; i++) {
                Node node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();
        leftView.levelOrderTraversal(getBinaryTree());

    }

}
