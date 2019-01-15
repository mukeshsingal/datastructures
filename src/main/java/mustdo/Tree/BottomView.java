package mustdo.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BottomView extends TreeUtil{
    public static void main(String[] args) {
        TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>();
        doVerticalOrderTraversal(getBianryTreeThree(), 0, map);
        for (Map.Entry<Integer, LinkedList<Node>> e :
                map.entrySet()) {
            LinkedList<Node> nodes = e.getValue();
            System.out.println(nodes.get(0).key + " ");
        }
    }

    static  void doVerticalOrderTraversal(Node root, int hDistance, TreeMap<Integer, LinkedList<Node>> map) {
        if(root == null){
            return;
        }
        doVerticalOrderTraversal(root.left, hDistance -1, map);
        doVerticalOrderTraversal(root.right, hDistance +1, map);
        if(map.containsKey(hDistance)) {
            map.get(hDistance).add(root);
        }
        else {
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.add(root);
            map.put(hDistance, nodes);
        }
    }


}
