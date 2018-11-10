package ds.graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedGraph extends Graph {

    public LinkedHashMap<Vertex, LinkedList<Vertex>> adjacencyList = new LinkedHashMap<>();

    public void addVertex(Vertex vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(Vertex vertex) {
        adjacencyList.remove(vertex);
        for (Map.Entry<Vertex, LinkedList<Vertex>> entry : adjacencyList.entrySet()) {
            entry.getValue().remove(vertex);
        }
    }

    public void addEdge(Vertex first, Vertex second) {
        this.adjacencyList.get(first).addFirst(second);
        this.adjacencyList.get(second).addFirst(first);
    }

    public void removeEdge(Vertex first, Vertex second) {
        this.adjacencyList.get(first).remove(second);
        this.adjacencyList.get(second).remove(first);
    }

    public boolean isConnected(Vertex first, Vertex second) {
        if (adjacencyList.containsKey(first) && adjacencyList.containsKey(second)) {
            return adjacencyList.get(first).contains(second);
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (Map.Entry<Vertex, LinkedList<Vertex>> entry : adjacencyList.entrySet()) {
            s = s + "[" + entry.getKey().data + "] = [";
            for (Vertex v : entry.getValue()) {
                s = s + v.data + ", ";
            }
            if (s.endsWith(", "))
                s = s.substring(0, s.length() - 2);
            s = s + "]\n";
        }
        return s;
    }
}