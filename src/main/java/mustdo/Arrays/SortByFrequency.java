package mustdo.Arrays;

import java.util.*;

public class SortByFrequency {
    static class Node {
        int number;
        int freq;

        public Node(int number, int freq) {
            this.number = number;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" + "number=" + number + ", freq=" + freq + '}';
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> mappings = new HashMap<>();
        int[] arr = {1, 2, 3, 4, 5, 2, 2, 1, 1};
        for (int i : arr) {
            if (mappings.containsKey(i)) {
                mappings.put(i, mappings.get(i) + 1);
            } else {
                mappings.put(i, 1);
            }
        }
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mappings.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        nodes.sort((o1, o2) -> o1.freq > o2.freq ? -1 : 1);
        System.out.println(nodes);

    }
}
