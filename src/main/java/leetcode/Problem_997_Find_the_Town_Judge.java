package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Node4 {
    public int val;
    public List<Node4> children;

    Node4(int val, List<Node4> children) {
        this.val = val;
        this.children = children;
    }

    public boolean includes(Node4 other) {
        for(Node4 n : children) {
            if (n.val == other.val) {
                return true;
            }
        }

        return false;
    }
}

public class Problem_997_Find_the_Town_Judge {

    public int findJudge(int N, int[][] trust) {
        //
        // in this problem, we want to create a directed graph.
        // The graph is represented as an array(or hashmap) of linked lists.
        // Each head node, maintains a list of nodes it trusts.
        // To find the judge, means to find the head node without children,
        // and to assert that this same node, is included in the list of all the other nodes.

        if (N == 1) return 1;


        // I will keep a reference to the nodes in a hashmap.
        // because it simplifies finding nodes by value.
        Map<Integer, Node4> graph = new HashMap<>();

        // First we will build the graph
        for(int[] pair : trust) {
            Node4 nodeA = new Node4(pair[0], new LinkedList<>());
            Node4 nodeB = new Node4(pair[1], new LinkedList<>());

            // initialize if new
            graph.putIfAbsent(nodeA.val, nodeA);
            graph.putIfAbsent(nodeB.val, nodeB);

            // update node
            Node4 n = graph.get(nodeA.val);
            n.children.add(nodeB);
            graph.put(n.val, n);
        }

        // Then we will find our judge, which is the node without children
        Node4 judge = null;
        for(Map.Entry<Integer, Node4> entry : graph.entrySet()) {
            Node4 n = entry.getValue();
            if (n.children.size()  == 0) {
                judge = n;
                break;
            }
        }

        // If all nodes have children, the judge will be null.
        if (judge == null) {
            return -1;
        }

        // For each node other than the judge, we want to make sure their children nodes include the judge.
        for(Map.Entry<Integer, Node4> entry : graph.entrySet()) {
            Node4 n = entry.getValue();

            if(n.val == judge.val) {
                continue;
            }

            if(!n.includes(judge)) {
                return -1;
            }
        }

        // if we made it here, it means they all included the judge.
        return judge.val;
    }
}