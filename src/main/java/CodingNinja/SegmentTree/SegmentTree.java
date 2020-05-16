package CodingNinja.SegmentTree;

import java.util.Arrays;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4,5};
        int len = arr.length;
        int[] tree = new int[len * 2];

        build(arr, tree, 0, len - 1, 1);
        System.out.println(Arrays.toString(tree));

        update(arr, tree, 2, 10);
        System.out.println(Arrays.toString(tree));


        System.out.println("QUERY 0,4 => " + query(tree, 0, 4, arr.length-1));
        System.out.println("QUERY 2,4 => " + query(tree, 2, 4, arr.length-1));

    }

    private static void build(int[] numbers, int[] tree, int start, int end, int treeNodeIndex) {
        if (start == end) {
            tree[treeNodeIndex] = numbers[start];

            return;
        }
        int mid = (start + end) / 2;

        build(numbers, tree, start, mid, 2 * treeNodeIndex);
        build(numbers, tree, mid + 1, end, (2 * treeNodeIndex) + 1);

        tree[treeNodeIndex] = tree[2 * treeNodeIndex] + tree[(2 * treeNodeIndex) + 1];

    }

    private static void update(int[] numbers, int[] tree, int updateIndex, int updateValue) {
        update(numbers, tree, 0, numbers.length - 1, 1, updateIndex, updateValue);
    }

    private static void update(int[] numbers, int[] tree, int start, int end, int treeNodeIndex, int updateIndex,
            int updateValue) {

        if (start == end && start == updateIndex) {
            tree[treeNodeIndex] = updateValue;
            numbers[updateIndex] = updateValue;
            return;
        }

        int mid = (start + end) / 2;

        if (updateIndex > mid) {
            update(numbers, tree, mid + 1, end, 2 * treeNodeIndex + 1, updateIndex, updateValue);
            tree[treeNodeIndex] = tree[2 * treeNodeIndex] + tree[2 * treeNodeIndex + 1];
        } else {
            update(numbers, tree, start, mid, 2 * treeNodeIndex, updateIndex, updateValue);
            tree[treeNodeIndex] = tree[2 * treeNodeIndex] + tree[2 * treeNodeIndex + 1];
        }
    }

    private static int query(int[] tree, int qStart, int qEnd, int size) {
        return query(tree, 0, size, 1 , qStart, qEnd);
    }

    private static int query(int[] tree, int start, int end, int treeNodeIndex, int qStart, int qEnd) {
        
        //Competely outside the give range
        if(start > qEnd || end < qStart) {
            return 0;
        }
        //Competely inside the give range
        if(start >= qStart && end <= qEnd) {
            return tree[treeNodeIndex];
        }
        //Competely partially the give range
        int mid = (start + end) /2;
        int ans1 = query(tree, start, mid, 2*treeNodeIndex, qStart, qEnd);
        int ans2 = query(tree, mid+1, end, 2*treeNodeIndex+1, qStart, qEnd);

        return ans1 + ans2;   
    }
}