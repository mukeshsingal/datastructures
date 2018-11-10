package ds.trees;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    private class TrieNode {
        char key;
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }

        public TrieNode(char c) {
            this();
            this.key = c;
        }
    }

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode(c);
                current.children.put(c, node);
            }

            current = node;
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }

            current = node;
        }
        return current.endOfWord;
    }

    public void remove(String word) {
        if (word == null || word.length() == 0) return;
        removeUtil(word, root);
    }

    public boolean removeUtil(String word, TrieNode current) {
        if (word.length() == 0) {
            current.endOfWord = current.children.size() == 0;
            return current.endOfWord;
        }

        char c = word.charAt(0);
        if (current.children.containsKey(c) && removeUtil(word.substring(1), current.children.get(c))) {
            current.children.remove(current.children.get(c).key);
            return current.children.size() == 0 && !current.endOfWord;
        }

        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Mukesh");
        trie.insert("Mukes");

        System.out.println("Mueksh -> " + trie.search("Mukesh"));
        System.out.println("Mueksh -> " + trie.search("Mukes"));
        System.out.println("Remove Mukes -> ");
        trie.remove("Mukesh");
        trie.remove("Mukes");
        System.out.println("seach Mukesh-> " + trie.search("Mukesh"));
        System.out.println("Search Mukes-> " + trie.search("Mukes"));
    }
}

