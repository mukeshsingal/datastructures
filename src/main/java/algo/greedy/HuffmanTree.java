package algo.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    public static void main(String[] args) {

        String inputString = "This is Huffman Encoding";
        System.out.println("Input String is :" + inputString);

        HuffmanTree huffmanTree = new HuffmanTree();

        PriorityQueue<HuffmanNode> minHeap = huffmanTree.initMinHeap(inputString);
        HuffmanNode huffmanTreeRoot = huffmanTree.constructMinHeap(minHeap);

        //encode string
        String encodedString = huffmanTree.encode(huffmanTreeRoot, inputString);
        System.out.println("Encoded String : " + encodedString);

        //decode the string
        String decodedString = huffmanTree.decode(huffmanTreeRoot, encodedString);
        System.out.println("Decoded String :" + decodedString);
    }

    public PriorityQueue<HuffmanNode> initMinHeap(String inputString) {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<HuffmanNode>();

        HashMap<Character, Integer> map = getCharactersFreq(inputString);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            HuffmanNode node
                    = new HuffmanNode(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        return minHeap;
    }

    public HashMap<Character, Integer> getCharactersFreq(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : text.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
                continue;
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }


    public HuffmanNode constructMinHeap(PriorityQueue<HuffmanNode> minHeap) {
        HuffmanNode root = null;
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();

            HuffmanNode node = new HuffmanNode(
                    '$',
                    left.frequency + right.frequency);
            node.left = left;
            node.right = right;
            root = node;
            minHeap.add(node);
        }
        return root;
    }

    public HashMap<Character, String> getCodes(HuffmanNode root, String s, HashMap<Character, String> map) {
        if (root == null) return map;

        if (root.left == null && root.right == null && root.data != '$') {
            map.put(root.data, s);
            return map;
        }

        map = getCodes(root.left, s + "0", map);
        return getCodes(root.right, s + "1", map);
    }


    public String decode(HuffmanNode root, String encodedString) {
        String decodedString = "";
        HuffmanNode temp = root;
        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) == '0') {
                temp = temp.left;
            } else {
                temp = temp.right;
            }

            if (temp.left == null && temp.right == null) {
                decodedString += temp.data;
                temp = root;
            }
        }
        return decodedString;
    }

    public String encode(HuffmanNode root, String inputString) {
        String encodedString = "";
        HashMap<Character, String> codes = getCodes(root, "", new HashMap<Character, String>());
        for (Character c : inputString.toCharArray()) {
            encodedString += codes.get(c);
        }
        return encodedString;
    }

}

class HuffmanNode implements Comparable<HuffmanNode> {

    int frequency;
    char data;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char data, int frequency) {
        this.frequency = frequency;
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}
