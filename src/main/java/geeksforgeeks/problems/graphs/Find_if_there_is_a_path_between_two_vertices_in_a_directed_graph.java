package geeksforgeeks.problems.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Find_if_there_is_a_path_between_two_vertices_in_a_directed_graph {
    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph(4);

        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 0);
        directedGraph.addEdge(3, 3);

        System.out.println(directedGraph.isPathExist(1, 1));

    }


    static class DirectedGraph {
        private int numberOfVertices;
        private LinkedList<Integer> adjacencyList[];


        DirectedGraph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjacencyList = new LinkedList[numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        /* TODO : get it cleared what are the paramaters actually */
        void addEdge(int vertex1, int vertex12) {
            adjacencyList[vertex1].add(vertex12);
        }

        boolean isPathExist(int startVertex, int destinationVertex) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startVertex);

            boolean visited[] = new boolean[numberOfVertices];
            visited[startVertex] = true;

            while (!queue.isEmpty()) {
                int vertex = queue.remove();
                System.out.print(vertex + " - ");
                if (vertex == destinationVertex) {
                    return true;
                }

                for (int i : adjacencyList[vertex]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            return false;
        }
    }
}


