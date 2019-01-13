package mustdo.Graph;

import java.util.LinkedList;
import java.util.List;

public class Cycle {
    static class Graph {
        int noOfVertices;
        LinkedList<Integer> adj[];

        public Graph(int noOfVertices) {
            this.noOfVertices = noOfVertices;
            adj = new LinkedList[noOfVertices];
            for (int i = 0; i < noOfVertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int dest) {
            adj[source].add(dest);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[noOfVertices];
            boolean[] callStack = new boolean[noOfVertices];

            for (int i = 0; i < noOfVertices; i++)
                if (isCyclicUtil(i, visited, callStack))
                    return true;
            return false;
        }

        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] callStack) {
            if (callStack[i]) {
                return true;
            }
            if (visited[i]) {
                return false;
            }

            visited[i] = true;
            callStack[i] = true;
            List<Integer> children = adj[i];
            for (Integer c : children)
                if (isCyclicUtil(c, visited, callStack))
                    return true;

            callStack[i] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
