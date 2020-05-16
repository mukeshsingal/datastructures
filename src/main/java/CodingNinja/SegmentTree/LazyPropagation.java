package CodingNinja.SegmentTree;

import java.util.Arrays;

class LazyPropagation {

    public static void main(String[] args) {
        int[] arr = { 1, 3, -2,4};
        int len = arr.length;
        int[] tree = new int[len * 2];
        int[] lazyTree = new int[len * 2];

        build(arr, tree, 0, len - 1, 1);
        System.out.println(Arrays.toString(tree));

        updateLazy(arr, tree, lazyTree, 0, 3, 3);
        updateLazy(arr, tree, lazyTree, 0, 1, 2);
        System.out.println(Arrays.toString(tree));
        System.out.println(Arrays.toString(lazyTree));


        // System.out.println("QUERY 0,4 => " + query(tree, 0, 4, arr.length-1));
        // System.out.println("QUERY 2,4 => " + query(tree, 2, 4, arr.length-1));

    }

    private static void build(int[] numbers, int[] tree, int start, int end, int treeNodeIndex) {
        if (start == end) {
            tree[treeNodeIndex] = numbers[start];

            return;
        }
        int mid = (start + end) / 2;

        build(numbers, tree, start, mid, 2 * treeNodeIndex);
        build(numbers, tree, mid + 1, end, (2 * treeNodeIndex) + 1);

        tree[treeNodeIndex] = Math.min(tree[2 * treeNodeIndex], tree[(2 * treeNodeIndex) + 1]);

    }

    private static void updateLazy(int[] numbers, int[] tree, int[] lazyTree, int updateStart, int updateEnd, int updateValue) {
        update(numbers, tree, lazyTree, 0, numbers.length - 1, 1, updateStart, updateEnd, updateValue);
    }

    private static void update(
        int[] numbers, 
        int[] tree, 
        int[] lazyTree, 
        int start, 
        int end, 
        int treeNodeIndex, 
        int updateStart,
        int updateEnd,
        int updateValue) {

        if(start > end) {
            return;
        }

        if(lazyTree[treeNodeIndex] !=0 ) {
            tree[treeNodeIndex] += lazyTree[treeNodeIndex];
            // not a leaf, then ask to update child also 
            if(start != end) {
                lazyTree[2*treeNodeIndex] += lazyTree[treeNodeIndex];
                lazyTree[2*treeNodeIndex+1] += lazyTree[treeNodeIndex];
            }
            lazyTree[treeNodeIndex] = 0;
        }
        // No overlap
        if(updateStart > end || updateEnd < start) {
            return;
        }

        if(updateStart <= start &&  updateEnd >= end) {
            tree[treeNodeIndex] += updateValue;
            if(start != end) {
                lazyTree[2*treeNodeIndex] += updateValue;
                lazyTree[2*treeNodeIndex+1] += updateValue;
            }
            return;
        }

        //partial overlap

        int mid= (start + end) /2;
        update(numbers, tree, lazyTree, start, mid, 2*treeNodeIndex, updateStart, updateEnd, updateValue);
        update(numbers, tree, lazyTree, mid+1, end, 2*treeNodeIndex+1, updateStart, updateEnd, updateValue);
    }

  
}