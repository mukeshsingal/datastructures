package CodingNinja.SegmentTree;

import java.util.Arrays;

class SegmentTreeNode {
    int max;
    int sMax;
    SegmentTreeNode(int max, int sMax) {
        this.max = max;
        this.sMax = sMax;
    }
    @Override
    public String toString() {
        return " => max =" + this.max + " sMax =" + this.sMax;
    }
}

public class MaximumSumPair {
    
    public static void main(String[] args) {
        int[] arr = { 7, 3, 3, 4, 6};
        int len = arr.length;

        SegmentTreeNode[] tree = new SegmentTreeNode[len * 4];

        build(arr, tree, 0, len - 1, 1);
        System.out.println(Arrays.toString(tree));

        // update(arr, tree, 2, 10);
        // System.out.println(Arrays.toString(tree));


        System.out.println("QUERY 0,4 => " + query(tree, 0, 4, arr.length-1));
        System.out.println("QUERY 2,4 => " + query(tree, 2, 4, arr.length-1));
        System.out.println("QUERY 2,2 => " + query(tree, 2, 2, arr.length-1));

    }

    private static void build(int[] numbers, SegmentTreeNode[] tree, int start, int end, int treeNodeIndex) {
        if (start == end) {
            tree[treeNodeIndex] = new SegmentTreeNode(numbers[start], 0);
            return;
        }
        int mid = (start + end) / 2;

        build(numbers, tree, start, mid, 2 * treeNodeIndex);
        build(numbers, tree, mid + 1, end, (2 * treeNodeIndex) + 1);

        SegmentTreeNode node1 =  tree[2 * treeNodeIndex];
        SegmentTreeNode node2 = tree[(2 * treeNodeIndex) + 1];
        
        int max = Math.max(node1.max, node2.max);
        int sMax = Math.min(Math.max(node1.max, node2.sMax), Math.max(node1.sMax, node2.max)); 
        tree[treeNodeIndex] = new SegmentTreeNode(max, sMax);

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

    private static int query(SegmentTreeNode[] tree, int qStart, int qEnd, int size) {
        SegmentTreeNode node = query(tree, 0, size, 1 , qStart, qEnd);
        return node.max + node.sMax;
    }

    private static SegmentTreeNode query(SegmentTreeNode[] tree, int start, int end, int treeNodeIndex, int qStart, int qEnd) {
        
        //Competely outside the give range
        if(start > qEnd || end < qStart) {
            return new SegmentTreeNode(0,0);
        }
        //Competely inside the give range
        if(start >= qStart && end <= qEnd) {
            return new SegmentTreeNode(tree[treeNodeIndex].max, tree[treeNodeIndex].sMax);
        }
        //Competely partially the give range
        int mid = (start + end) /2;
        SegmentTreeNode node1 = query(tree, start, mid, 2*treeNodeIndex, qStart, qEnd);
        SegmentTreeNode node2 = query(tree, mid+1, end, 2*treeNodeIndex+1, qStart, qEnd);
        
        int max = Math.max(node1.max, node2.max);
        int sMax = Math.min(Math.max(node1.max, node2.sMax), Math.max(node1.sMax, node2.max)); 
        
        return new SegmentTreeNode(max, sMax);
    }
}