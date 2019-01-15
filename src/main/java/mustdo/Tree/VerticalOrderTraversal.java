package mustdo.Tree;

import java.util.*;

public class VerticalOrderTraversal extends TreeUtil {
    public static void main(String[] args) {
        TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>();
        doVerticalOrderTraversal(getBinaryTree2(), 0, map);
        for (Map.Entry<Integer, LinkedList<Node>> e :
                map.entrySet()) {
            LinkedList<Node> nodes = e.getValue();
            for (Node n :
                    nodes) {
                System.out.print(n.key + " ");
            }
            System.out.println();
        }

    }

    static void doVerticalOrderTraversal(Node root, int hdistance, TreeMap<Integer, LinkedList<Node>> map) {
        if (root == null) {
            return;
        }
        doVerticalOrderTraversal(root.left, hdistance - 1, map);
        doVerticalOrderTraversal(root.right, hdistance + 1, map);
        if (map.containsKey(hdistance)) {
            map.get(hdistance).add(root);
        } else {
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.add(root);
            map.put(hdistance, nodes);
        }
    }
}
