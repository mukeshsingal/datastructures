package mustdo.Graph;

import java.util.LinkedList;
import java.util.List;

public class DFS {
    static class Graph {
        private int noOfVertices;
        private LinkedList<Integer> adjacencyList[];

        public Graph(int noOfVertices) {
            this.noOfVertices = noOfVertices;
            adjacencyList = new LinkedList[noOfVertices];

            //Initilize all the elements of array
            for (int i = 0; i < noOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }

        void doDfs() {
            boolean visited[] = new boolean[noOfVertices];
            for (int i = 0; i < noOfVertices; ++i)
                if (!visited[i])
                    DFSUtil(i, visited);
        }

        private void DFSUtil(int i, boolean[] visited) {
            visited[i] = true;
            System.out.print(i + " ");

            List<Integer> nodes = adjacencyList[i];
            for (int j : nodes) {
                if (!visited[j])
                    DFSUtil(j, visited);
            }
            ;
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

        System.out.println("Following is Depth First Traversal");

        g.doDfs();

    }
}
