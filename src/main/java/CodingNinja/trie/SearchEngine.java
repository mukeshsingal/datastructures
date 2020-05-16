package CodingNinja.trie;

public class SearchEngine {
    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.head = new TrieNode2(0);

        String[] strings = {"abc", "abe", "abd"};
        int[] weights = {2, 3, 4};

        for (int i = 0; i < weights.length; i++) {
            trie.insert(strings[i], weights[i]);
        }


        System.out.println("AB " + trie.query("ab"));
        System.out.println("abc " + trie.query("abc"));
        System.out.println("a " + trie.query("a"));
        System.out.println("abe " + trie.query("abe"));

    }
}

class TrieNode2 {
    
    TrieNode2[] nodes;
    int weight;

    TrieNode2 (int weight) {
        this.nodes = new TrieNode2[26];
        this.weight = weight;
    }
}

class Trie2 {
    TrieNode2 head;

    public void insert(String s, int weight) {
        TrieNode2 current = head;

        char[] chars = s.toCharArray();
        
        for(char c : chars) {
            int index = c - 'a';
            if(current.nodes[index] == null) {
                current.nodes[index] = new TrieNode2(weight);
            }
            if(current.weight < weight) {
                current.weight = weight;
            }
            current = current.nodes[index];
        }
    }

    public int query(String s) {
        TrieNode2 current = head;

        char[] chars = s.toCharArray();
        
        for(char c : chars) {
            int index = c - 'a';
            current = current.nodes[index];
        }
        return current.weight;
    }
}