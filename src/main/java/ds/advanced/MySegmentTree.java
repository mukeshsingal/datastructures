package ds.advanced;

/**
 * Implemented for Range Minimum Query.
 * We have any array[0..n-1]. We should be able to find minimum value from index qs to qe where 0<= qs <= qe <= n-1.
 *
 * <pre>
 * Simple solution run a look to find minimum from qs to qe. O(N) worst case.
 * But segment tree complexity in such case is O(Log n)
 * <pre>
 * Properties
 * Leaf nodes are elements of input array
 * Each internal nodes represents minimum value under leaf.
 *
 * https://www.youtube.com/watch?v=wyt5_GJqsMw&list=PLqM7alHXFySHCXD7r1J0ky9Zg_GBB1dbk&index=15
 */
public class MySegmentTree {
    //Since Segment try will always be full, we can construct it using array

    public static int[] createSegmentTree(
            int[] array,
            int startIndex,
            int endIndex,
            int currentIndex,
            int[] tree){

        if(startIndex == endIndex) {
            tree[currentIndex] = array[startIndex];

        }

        return tree;
    }

    public static void main(String[] args) {

    }
}
