package geeksforgeeks.problems.graphs;

import ds.graph.GraphUtils;
import ds.graph.UndirectedGraph;
import ds.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Cycle_In_Directed_Graph extends GraphUtils {
    public static void main(String[] args) {
        UndirectedGraph graph = getUndirectedGraph();
        System.out.println("Cyclic Graph -> Answer : " + isCyclic(graph));
    }

    public static boolean isCyclic(UndirectedGraph graph) {
        Vertex startingVertex = graph.adjacencyList.keySet().stream()
                .findFirst()
                .get();

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startingVertex);

        LinkedList<Vertex> visited = new LinkedList<>();
        visited.add(startingVertex);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();

            LinkedList<Vertex> neighbours = graph.adjacencyList.get(vertex);

            for (Vertex vertex1 : neighbours) {
                if (!visited.contains(vertex1)) {
                    visited.add(vertex1);
                    queue.add(vertex1);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
