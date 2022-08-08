package algo.greedy;

import java.util.Arrays;

/**
 * Kruskal’s Minimum Spanning Tree Algorithm
 *
 * A minimum spanning tree (MST) or minimum weight spanning tree for a weighted,
 * connected and undirected graph is a spanning tree with weight less than or
 * equal to the weight of every other spanning tree.
 *
 * A minimum spanning tree has (V – 1) edges where V is the number of vertices in
 * the given graph.
 *
 * Algorithm:
 * 1. create a List of Edges
 * 2. Sort the List based on weight in increasing order
 * 3. Continue below steps for n-1 edges
 * 4. Pick and the first edge and add to MST
 * 5. Use Disjoint set Union Find Algorithm to detect cycle in graph
 *      1. If cycle exist then remove edge from MST
 *      2. If doesn't exist continue
 *
 */
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
        int x = find(subsets, edgeSrc);
        int y = find(subsets, edgeDest);

        //Attach Smaller rank tree under root of high rank tree
        //Union by rank
        if (subsets[x].rank < subsets[y].rank) {
            subsets[x].parent = y;
        } else if (subsets[x].rank > subsets[y].rank) {
            subsets[y].parent = x;
        } else {
            subsets[y].parent = x;
            subsets[x].rank++;
        }
    }

    public void kruskal() {
        Edge result[] = new Edge[numberOfVertices - 1];
        for (int i = 0; i < numberOfVertices - 1; i++) {
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
