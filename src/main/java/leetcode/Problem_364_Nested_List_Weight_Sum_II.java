package leetcode;

public class Problem_364_Nested_List_Weight_Sum_II {


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        //Step 1 : find the max depth, and set counter to zero
//
//        return getDepthSumInverse(nestedList, 0);
//    }
//    private int getDepthSumInverse(List<NestedInteger> list, int sum) {
//
//        List<NestedInteger> nextLevel = new ArrayList<>();
//
//        for(NestedInteger i : list) {
//            if(i.isInteger()) {
//                sum += i.getInteger();
//            }
//            else {
//                nextLevel.addAll(i.getList());
//            }
//        }
//        return nextLevel.isEmpty() ? sum : sum + getDepthSumInverse(nextLevel, sum);
//    }

}