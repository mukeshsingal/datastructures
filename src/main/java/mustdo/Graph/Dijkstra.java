package mustdo.Graph;


import java.util.*;

public class Dijkstra {

    HashMap<Vertex, LinkedList<Edge>> adjList = new HashMap<>();

    static class Vertex {
        int name;
        int shortestPath;

        public Vertex(int name) {
            this.name = name;
            shortestPath = Integer.MAX_VALUE;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "name=" + name +
                    ", sp=" + shortestPath +
                    '}';
        }
    }

    static class Edge {
        Vertex src;
        Vertex destination;
        int weight;

        Edge(Vertex src, Vertex destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }


    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge e = new Edge(v1, v2, weight);
        LinkedList<Edge> list;
        if (adjList.containsKey(v1)) {
            list = adjList.get(v1);
        } else {
            list = new LinkedList<>();
        }
        list.add(e);
        adjList.put(v1, list);
        if(!adjList.containsKey(v2)) {
            adjList.put(v2, new LinkedList<>());
        }
    }

    Dijkstra() {
    }

    public void doDijkstra(Vertex startVertex) {

        Vertex currentVertex = startVertex;
        currentVertex.shortestPath = 0;
        boolean[] isVisited = new boolean[adjList.size()];

        Vertex minVertex = null;
        int minDistance;

        for (int i = 0; i < adjList.size(); i++) {
            minDistance = Integer.MAX_VALUE;
            List<Edge> edges = adjList.get(currentVertex);
            for (Edge e : edges) {
                if (e.destination.shortestPath >= currentVertex.shortestPath + e.weight) {
                    e.destination.shortestPath = currentVertex.shortestPath + e.weight;
                    if (minDistance > e.destination.shortestPath && !isVisited[e.destination.name -1]) {
                        minVertex = e.destination;
                        minDistance = e.destination.shortestPath;
                    }
                }
            }
            isVisited[currentVertex.name - 1] = true;
            currentVertex = minVertex;
        }

        for (Vertex e: adjList.keySet()) {
            System.out.println(e.name + " " + e.shortestPath);
        }
    }

    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v2, v4, 7);
        graph.addEdge(v3, v5, 3);
        graph.addEdge(v5, v4, 2);
        graph.addEdge(v5, v6, 5);
        graph.addEdge(v4, v6, 1);

        graph.doDijkstra(v1);
    }
}

