package ds.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

    private List<Node> allNodes = new ArrayList<>();
    private Map<T, Integer> nodePosition = new HashMap<>();

    public class Node {
        int weight;
        T key;

        Node(T key, int weight) {
            this.key = key;
            this.weight = weight;
        }
    }

    public void add(int weight, T key) {
        Node node = new Node(key, weight);
        allNodes.add(node);

        int size = allNodes.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;
        nodePosition.put(node.key, current);

        while (parentIndex >= 0) {
            Node parentNode = allNodes.get(parentIndex);
            Node currentNode = allNodes.get(current);

            if (parentNode.weight > currentNode.weight) {
                swap(parentNode, currentNode);
                updatePositionMap(parentNode.key,
                        currentNode.key,
                        parentIndex,
                        current);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    public Node extractMinNode() {
        int size = allNodes.size() - 1;
        Node minNode = new Node(allNodes.get(0).key, allNodes.get(0).weight);

        allNodes.get(0).weight = allNodes.get(size).weight;

        allNodes.get(0).key = allNodes.get(size).key;


        nodePosition.remove(minNode.key);
        nodePosition.remove(allNodes.get(0));
        nodePosition.put(allNodes.get(0).key, 0);
        allNodes.remove(size);

        /*heapify down*/

        int currentIndex = 0;
        size--;
        while (true) {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left > size) {
                break;
            }
            if (right > size) {
                right = left;
            }

            int smallerIndex = allNodes.get(left).weight <= allNodes.get(left).weight ? left : right;

            if (allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight) {
                swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
                updatePositionMap(allNodes.get(currentIndex).key,
                        allNodes.get(smallerIndex).key,
                        currentIndex,
                        smallerIndex);
                currentIndex = smallerIndex;
            } else {
                break;
            }
        }
        return minNode;
    }

    public T min() {
        return allNodes.get(0).key;
    }

    public boolean isEmpty() {
        return allNodes.size() == 0;
    }

    private void printPositionMap() {
        System.out.println(nodePosition);
    }

    private void swap(Node node1, Node node2) {
        int wight = node1.weight;
        T data = node1.key;

        node1.key = node2.key;
        node1.weight = node2.weight;

        node2.key = data;
        node2.weight = wight;
    }

    private void updatePositionMap(T data1, T data2, int position1, int position2) {
        nodePosition.remove(data1);
        nodePosition.remove(data2);
        nodePosition.put(data1, position1);
        nodePosition.put(data2, position2);
    }

    public void printHeap() {
        for (Node n : allNodes) {
            System.out.println(nodePosition.get(n.key) + " - " + n.weight + " " + n.key);
        }
    }

    public void decrease(T data, int newWeight) {
        Integer position = nodePosition.get(data);
        allNodes.get(position).weight = newWeight;
        int parent = (position - 1) / 2;
        while (parent >= 0) {
            System.out.println("it ran " + parent);
            if (allNodes.get(parent).weight > allNodes.get(position).weight) {
                swap(allNodes.get(parent), allNodes.get(position));
                updatePositionMap(allNodes.get(parent).key, allNodes.get(position).key, parent, position);
                position = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BinaryMinHeap<String> heap = new BinaryMinHeap<>();
        heap.add(3, "Mukesh");
        heap.add(4, "Vejita");
        heap.add(5, "Trunks");
        heap.add(1, "Friza");
        heap.add(10, "Goku");

        //heap.printPositionMap();
        heap.printHeap();
        System.out.println(heap.extractMinNode().key);
        heap.decrease("Goku", 2);
        heap.printHeap();
        System.out.println(heap.min());

    }
}
