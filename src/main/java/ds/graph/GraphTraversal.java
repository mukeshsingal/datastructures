package ds.graph;

import java.util.*;

public class GraphTraversal extends GraphUtils {

    public static void main(String[] args) {
        traverse(getUndirectedGraph());
    }

    static void traverse(UndirectedGraph graph) {
        if (graph == null)
            return;
/*
        for (Vertex v : graph.adjacencyList.keySet()) {
            doBFS(graph, v);
        }*/

  /*      System.out.println("==================");*/

        for (Vertex v : graph.adjacencyList.keySet()) {
            doDFSUsingRecursion(graph, v, new LinkedHashSet<>());
            break;
        }
    }

    private static void doBFS(UndirectedGraph graph, Vertex startingVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startingVertex);

        LinkedHashSet<Vertex> visited = new LinkedHashSet<>();
        visited.add(startingVertex);

        String s = "[" + startingVertex.data + "] = [";

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            s = s + vertex.data + ", ";

            LinkedList<Vertex> neighbours = graph.adjacencyList.get(vertex);

            for (Vertex vertex1 : neighbours) {
                if (!visited.contains(vertex1)) {
                    visited.add(vertex1);
                    queue.add(vertex1);
                }
            }
        }

        s = s.substring(0, s.length() - 2);
        s = s + "]";
        System.out.println(s);
    }

    private static void doDFS(UndirectedGraph graph, Vertex startingVertex) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(startingVertex);

        LinkedHashSet<Vertex> visited = new LinkedHashSet<>();
        visited.add(startingVertex);

        String s = "[" + startingVertex.data + "] = [";

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            s = s + vertex.data + ", ";

            LinkedList<Vertex> neighbours = graph.adjacencyList.get(vertex);

            for (Vertex vertex1 : neighbours) {
                if (!visited.contains(vertex1)) {
                    visited.add(vertex1);
                    stack.push(vertex1);
                }
            }
        }

        s = s.substring(0, s.length() - 2);
        s = s + "]";
        System.out.println(s);
    }

    private static void doDFSUsingRecursion(UndirectedGraph graph, Vertex startingVertex, LinkedHashSet<Vertex> visited) {

        LinkedList<Vertex> neighbours = graph.adjacencyList.get(startingVertex);

        System.out.print(startingVertex.data + " -> ");
        visited.add(startingVertex);

        for (Vertex vertex1 : neighbours) {
            if (!visited.contains(vertex1)) {
                visited.add(vertex1);
                doDFSUsingRecursion(graph, vertex1, visited);
            }
        }
    }

    private static void doBFSUsingRecursion(UndirectedGraph graph, Vertex startingVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startingVertex);

        LinkedHashSet<Vertex> visited = new LinkedHashSet<>();
        visited.add(startingVertex);

        String s = "[" + startingVertex.data + "] = [";

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            s = s + vertex.data + ", ";

            LinkedList<Vertex> neighbours = graph.adjacencyList.get(vertex);

            for (Vertex vertex1 : neighbours) {
                if (!visited.contains(vertex1)) {
                    visited.add(vertex1);
                    queue.add(vertex1);
                }
            }
        }

        s = s.substring(0, s.length() - 2);
        s = s + "]";
        System.out.println(s);
    }

}
