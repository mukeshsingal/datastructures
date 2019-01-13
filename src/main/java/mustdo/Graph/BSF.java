package mustdo.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSF {
    static class Graph {
        int noOfVertics;
        LinkedList<Integer> adjacencyList[];

        Graph(int noOfVertics) {
            this.noOfVertics = noOfVertics;
            adjacencyList = new LinkedList[noOfVertics];
            for (int i = 0; i < noOfVertics; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }

        void doBFS(int source) {
            boolean[] visited = new boolean[noOfVertics];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[source] = true;
            queue.add(source);
            while (!queue.isEmpty()) {
                source = queue.poll();
                System.out.print(source + " ");
                List<Integer> nodes = adjacencyList[source];
                for (int i : nodes) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.doBFS(2);

    }
}
