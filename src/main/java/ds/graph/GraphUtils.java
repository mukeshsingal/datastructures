package ds.graph;

public class GraphUtils extends Graph {

    static Vertex A = new Vertex("A");
    static Vertex B = new Vertex("B");
    static Vertex C = new Vertex("C");
    static Vertex D = new Vertex("D");


    public static void main(String[] args) {
        getDirectedGraph().print();
    }

    /*
     *  (A) --- (D)
     *   |
     *   |
     *   |
     *   (B) --- (C)
     */
    public static UndirectedGraph getUndirectedGraph() {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, C);
        return graph;
    }


    /*
     *  (A) --->(D)
     *   | \
     *   |    \
     *   |      \
     *   v       v
     *   (B) --- >(C)
     */
    public static DirectedGraph getDirectedGraph() {
        DirectedGraph graph = new DirectedGraph();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(A, C);
        graph.addEdge(B, C);

        return graph;
    }

    /*
     *  (A) --->(D)
     *   | ^
     *   |   \
     *   |    \
     *   |      \
     *   v       \
     *   (B) --- >(C)
     */
    public static UndirectedGraph getCyclicUndirectedGraph() {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);

        graph.addEdge(A, B);
        graph.addEdge(B, C);
        graph.addEdge(C, A);
        graph.addEdge(A, D);

        return graph;
    }
}
