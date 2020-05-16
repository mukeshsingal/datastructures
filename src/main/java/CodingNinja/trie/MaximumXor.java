package CodingNinja.Trie;

public class MaximumXor {
    public static void main(String[] args) {
        int arr[] = { 8, 1, 2, 15, 10, 5 };
 
        Trie2 trie = new Trie2();
        trie.head = new TrieNode2();

        for (int i : arr) {
            trie.insert(i);
        }
        System.out.println(trie.findMaxXorPair(arr));

    }
}

class TrieNode {
    TrieNode2 left;
    TrieNode2 right;
}

class Trie {
    TrieNode2 head;

    /**
     * Here eg. Number is 2 so its binary representation will be
     * 00000000000000000000000000000010 When inserting these bits into trie.. - For
     * every zero we will go right - for every one we will go left to get max xor
     * 
     * XOR will be max only if we always xor with oppsoite bit
     * 
     * @param number to be inserted in trie
     */
    public void insert(int number) {
        TrieNode2 current = head;

        for (int i = 0; i <= 31; i++) {

            // Find out if the bit is set for ith index
            int bitValue = (number >> i) & 1;

            if (bitValue == 1) {
                if (current.left == null) {
                    current.left = new TrieNode2();
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TrieNode2();
                }
                current = current.right;
            }
        }
    }

    public int findMaxXorPair(int[] arr) {
        int globalMax = Integer.MIN_VALUE;

        for (int value : arr) {

            int currentMax = 0;
            TrieNode2 current = head;

            for (int i = 0; i <= 31; i++) {
                
                int bitValue = (value >> i) & 1;

                if (bitValue == 1) {
                    if (current.left != null) {
                        currentMax += Math.pow(2, i);
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                }
            }
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
}