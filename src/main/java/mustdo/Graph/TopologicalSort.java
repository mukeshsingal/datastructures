package mustdo.Graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static class Graph {
        private int noOfVertices;
        private LinkedList<Integer> adjacencyList[];

        public Graph(int noOfVertices) {
            this.noOfVertices = noOfVertices;
            adjacencyList = new LinkedList[noOfVertices];

            //Initilize all the elements of array
            for (int i = 0; i < noOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }


        // A recursive function used by topologicalSort
        void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
            visited[v] = true;
            LinkedList<Integer> list = adjacencyList[v];

            for (int j : list) {
                if (!visited[j])
                    topologicalSortUtil(j, visited, stack);
            }
            // Push current vertex to stack which stores result
            stack.push(v);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[noOfVertices];

            for (int i = 0; i < noOfVertices; i++)
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);

            // Print contents of stack
            while (!stack.empty())
                System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);


        System.out.println("Following is Depth First Traversal");

        g.topologicalSort();

    }
}
