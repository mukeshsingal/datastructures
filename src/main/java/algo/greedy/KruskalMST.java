package algo.greedy;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;

public class KruskalMST {
    int numberOfVertices;
    int numberOfEdges;
    Edge edges[];

    KruskalMST(int numberOfVertices, int numberOfEdges) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;

        this.edges = new Edge[numberOfEdges];
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public Edge() {

        }

        @Override
        public int compareTo(Edge otherEdge) {
            return this.weight - otherEdge.weight;
        }
    }

    class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public int find(Subset[] subsets, int vertex) {
        if (subsets[vertex].parent != vertex) {
            subsets[vertex].parent = find(subsets, subsets[vertex].parent);
        }
        return subsets[vertex].parent;
    }

    public void union(Subset[] subsets, int edgeSrc, int edgeDest) {
        int xRoot = find(subsets, edgeSrc);
        int yRoot = find(subsets, edgeDest);

        //Attach Smaller rank tree under root of high rank tree
        //Union by rank
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    public void kruskal() {
        Edge result[] = new Edge[numberOfVertices-1];
        for (int i = 0; i < numberOfVertices-1; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edges);

        Subset subsets[] = new Subset[numberOfVertices];
        for (int v = 0; v < subsets.length; ++v) {
            subsets[v] = new Subset(v, 0);
        }

        int e = 0;
        int i = 0;

        while (e < numberOfVertices - 1) {
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("MST is :");
        for (Edge edge : result) {
            System.out.println(edge.src + " -(" + edge.weight + ")-> " + edge.dest);
        }
    }

    public static void main(String[] args) {

        /* Let us create following weighted graph
         *        10
         *   0--------1
         *   |  \     |
         *  6|   5\   |15
         *   |      \ |
         *   2--------3
         *       4
         */

        int numberOfVertices = 4;
        int numberOfEdges = 5;

        KruskalMST graph = new KruskalMST(numberOfVertices, numberOfEdges);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.kruskal();
    }
}
