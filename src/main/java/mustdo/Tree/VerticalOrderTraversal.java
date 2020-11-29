package mustdo.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal extends TreeUtil {
    public static void main(String[] args) {

        (new VerticalOrderTraversal()).printVerticalOrder(getBinaryTree2());


    }

    private void printVerticalOrder(Node root) {

        TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>();

        doVOT(root, 0, map);

        for (Map.Entry<Integer, LinkedList<Node>> e : map.entrySet()) {

            LinkedList<Node> nodes = e.getValue();

            for (Node n : nodes) {
                System.out.print(n.key + " ");
            }
            System.out.println();
        }
    }

    private void doVOT(Node root, int hDistance, TreeMap<Integer, LinkedList<Node>> map) {
        if (root == null) {
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                Node node = pair.node;
                int hd = pair.hDistance;

                if(map.containsKey(hd)) {
                    map.get(hd).add(node);
                }
                else {
                    LinkedList<Node> list = new LinkedList<>();
                    list.add(node);
                    map.put(hd, list);
                }

                if(node.left != null) {
                    queue.add(new Pair(node.left, hd - 1));
                }
                if(node.right != null) {
                    queue.add(new Pair(node.right, hd + 1));
                }
            }
        }
    }

    class Pair {
        Node node;
        int hDistance;

        Pair(Node node, int hDistance) {
            this.node = node;
            this.hDistance = hDistance;

        }
    }
}
