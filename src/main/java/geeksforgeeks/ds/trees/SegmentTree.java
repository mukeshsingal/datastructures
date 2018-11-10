package geeksforgeeks.ds.trees;

/**
 *
 */
public class SegmentTree {
    int segmentTree[];

    SegmentTree(int[] array) {
        int numberOfElements = array.length;

        int height = (int) (Math.ceil(Math.log(numberOfElements) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, height) - 1;

        segmentTree = new int[max_size];
        constructSTUtil(array, 0, numberOfElements - 1, 0);
    }

    // A recursive function that constructs Segment Tree for array[start..end].
    // currentNodeIndex is index of current node in segment tree st
    int constructSTUtil(int[] elementArray, int start, int end, int currentNodeIndex) {

        /* When we found range with single element */
        if (start == end) {
            segmentTree[currentNodeIndex] = elementArray[start];
            return elementArray[start];
        }

        int mid = start + ((end - start) / 2);

        segmentTree[currentNodeIndex] = constructSTUtil(elementArray, start, mid, currentNodeIndex * 2 + 1) +
                constructSTUtil(elementArray, mid + 1, end, currentNodeIndex * 2 + 2);

        return segmentTree[currentNodeIndex];
    }


    private int getSum(int lengthOfArray, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > lengthOfArray || startIndex > endIndex) {
            System.out.println("Invalid Query Parameters");
        }
        return getSumUtil(0, lengthOfArray - 1, startIndex, endIndex, 0);
    }

    private int getSumUtil(int start, int end, int queryStartIndex, int queryEndIndex, int currentIndex) {
        if (queryStartIndex <= start && queryEndIndex >= end) {
            return segmentTree[currentIndex];
        }

        if (end < queryStartIndex || start > queryEndIndex)
            return 0;

        int mid = start + (end - start) / 2;

        return getSumUtil(start, mid, queryStartIndex, queryEndIndex, currentIndex * 2 + 1) +
                getSumUtil(mid + 1, end, queryStartIndex, queryEndIndex, currentIndex * 2 + 2);
    }

    public static void main(String[] args) {

        int input[] = {1, -1, 0, 1, 1};

        SegmentTree segmentTree = new SegmentTree(input);
        System.out.println("Sum of values in given range = " + segmentTree.getSum(input.length, 0, 4));

        segmentTree.updateValue(input, input.length, 1, 10);
    }

    private void updateValue(int[] input, int length, int index, int newValue) {
        if (index < 0 || index > input.length) {
            System.out.println("Index is invalid");
            return;
        }

        int diff = newValue - input[index];
        input[index] = newValue;

        updateValueUtil(0, input.length - 1, index, diff, 0);
    }

    private void updateValueUtil(int start, int end, int index, int diff, int currentIndex) {
        if (index < start || index > end) {
            return;
        }

        segmentTree[currentIndex] = segmentTree[currentIndex] + diff;

        if (start != end) {
            int mid = start + (end - start) / 2;
            updateValueUtil(start, mid, index, diff, currentIndex * 2 + 1);
            updateValueUtil(mid, end, index, diff, currentIndex * 2 + 2);
        }
    }

}

