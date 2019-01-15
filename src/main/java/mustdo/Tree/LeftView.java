package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView extends TreeUtil {

    void levelOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            int nodeCount = queue.size();
            if (nodeCount <= 0)
                break;
            boolean flag = true;
            while (nodeCount > 0) {
                Node node = queue.poll();
                if (flag) {
                    System.out.println("Node " + node.key);
                    flag = !flag;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();
        leftView.levelOrderTraversal(getBinaryTree());

    }

}
