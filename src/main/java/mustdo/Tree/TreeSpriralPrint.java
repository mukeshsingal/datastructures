package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSpriralPrint extends TreeUtil {
    public static void main(String[] args) {
        modifiedLevelOrderTraversal(1, getBinaryTree());
    }

    public static void modifiedLevelOrderTraversal(int count, Node root) {

        int numberOfNodesAtLevel;
        int changeDirectionCount = 0;

        boolean rightToLeft = false;

        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            changeDirectionCount++;
            numberOfNodesAtLevel = queue.size();

            for (int i = 0; i < numberOfNodesAtLevel; i++) {
                Node temp = queue.poll();

                if (rightToLeft)
                    stack.push(temp);
                else
                    System.out.print(temp.key + " ");

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

            }
            if (rightToLeft) {
                while (!stack.isEmpty()) {
                    Node temp = stack.pop();
                    System.out.print(temp.key + " ");
                }
            }

            rightToLeft = !rightToLeft;
            System.out.println();
        }
    }
}
