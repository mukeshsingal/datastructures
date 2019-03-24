package ds.disjointset;

/**
 * Disjoint set is a data structure that keeps track of a set of elements
 * partitioned into a number of disjoint(non overlapping) subsets.
 * <p>
 * Union Operation
 * Find Operation
 * <p>
 * To detect a cycle in a graph
 * 1. make subsets using both the vertices of the edge.
 * If both the vertices are in the same subset, a cycle is found.
 */

public class UnionFindAlgorithm {

    static Edge edge[];

    class Edge {
        int src, dest;
    }


    int numberOfVerticies, numberOfEdges;


    UnionFindAlgorithm(int numberOfVerticies, int numberOfEdges) {
        this.numberOfVerticies = numberOfVerticies;
        this.numberOfEdges = numberOfEdges;
        edge = new Edge[numberOfEdges];
        for (int i = 0; i < numberOfEdges; i++) {
            edge[i] = new Edge();
        }
    }

    int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int parent[], int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public boolean isCycle(UnionFindAlgorithm graph) {
        int parent[] = new int[graph.numberOfVerticies];
        for (int i = 0; i < graph.numberOfVerticies; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < graph.numberOfEdges; i++) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if (x == y) {
                return true;
            }

            graph.union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {

        /*   0
         *   | \
         *   |   \
         *   1 -- 2
         */

        int V = 3, E = 3;

        UnionFindAlgorithm graph = new UnionFindAlgorithm(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph)) {
            System.out.println("Graph Contains Cycle ");
        } else
            System.out.println("Graph Doesn't contain cycle");

    }

}
