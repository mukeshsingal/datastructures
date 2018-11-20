package algo.dp;

public class BellmanFordShortestPath {
    int numberOfVertices, numberOfEdges;
    Edge[] edges;
    Vertex[] vertices;

    static class Edge {
        int weight;
        Vertex src, destination;

        public Edge(int weight, Vertex src, Vertex destination) {
            this.weight = weight;
            this.src = src;
            this.destination = destination;
        }
    }

    static class Vertex {
        int shortestPath;
        char name;

        public Vertex(char name, int shortestPath) {
            this.shortestPath = shortestPath;
            this.name = name;
        }
    }

    public BellmanFordShortestPath(int numberOfVertices, int numberOfEdges) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        edges = new Edge[numberOfEdges];
        vertices = new Vertex[numberOfVertices];
    }

    /*            (B) ----2-------> E)
     *           ^   ^ \          /
     *      -1 /  |   \ \ 2      /
     *      (A)   |3   \  \     / -3
     *        \   |    1\  \   /
     *      4  v  v      \ v  v
     *           (C)<---- (D)
     *                5
     */
    public static void main(String[] args) {
        int numberOfVertices = 5;
        int numberOfEdges = 8;

        BellmanFordShortestPath bellmanFord = new BellmanFordShortestPath(numberOfVertices, numberOfEdges);

        Vertex A = new Vertex('A', Integer.MAX_VALUE);
        Vertex B = new Vertex('B', Integer.MAX_VALUE);
        Vertex C = new Vertex('C', Integer.MAX_VALUE);
        Vertex D = new Vertex('D', Integer.MAX_VALUE);
        Vertex E = new Vertex('E', Integer.MAX_VALUE);

        bellmanFord.vertices[0] = A;
        bellmanFord.vertices[1] = B;
        bellmanFord.vertices[2] = C;
        bellmanFord.vertices[3] = D;
        bellmanFord.vertices[4] = E;

        bellmanFord.edges[0] = new Edge(-1, A, B);
        bellmanFord.edges[1] = new Edge(4, A, C);
        bellmanFord.edges[2] = new Edge(3, B, C);
        bellmanFord.edges[3] = new Edge(2, B, D);
        bellmanFord.edges[4] = new Edge(2, B, E);
        bellmanFord.edges[5] = new Edge(5, D, C);
        bellmanFord.edges[6] = new Edge(1, D, B);
        bellmanFord.edges[7] = new Edge(-3, E, D);

        bellmanFord.findShortestPath(A);
    }

    private void findShortestPath(Vertex startVertex) {
        startVertex.shortestPath = 0;

        for (int i = 1; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfEdges; j++) {
                Vertex u = edges[j].src;
                Vertex v = edges[j].destination;
                int weight = edges[j].weight;
                if (u.shortestPath != Integer.MAX_VALUE && u.shortestPath + weight < v.shortestPath) {
                    v.shortestPath = u.shortestPath + weight;
                }
            }
        }
        printGraph();
    }

    public void printGraph() {
        for (Vertex e : vertices) {
            System.out.println("A - > " + e.name +" = "+ e.shortestPath);
        }
    }
}
