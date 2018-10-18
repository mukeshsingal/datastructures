package leetcode;

import geeksforgeeks.ds.MyLinkedList;

/**
 * URL : https://leetcode.com/problems/add-two-numbers/description/
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        next = null;
    }
}


public class AddTwoLinkedListNumbers {
    public static void main(String[] args) {
        MyLinkedList num1 = new MyLinkedList();
        MyLinkedList num2 = new MyLinkedList();

        num1.addToStart(3);
        num1.addToStart(4);
        num1.addToStart(2);

        num2.addToStart(4);
        num2.addToStart(6);
        num2.addToStart(5);

        num1.print(num1.head);
        num1.print(num2.head);
        sum(num1, num2);
        System.out.println("");

        MyLinkedList num3 = new MyLinkedList();
        MyLinkedList num4 = new MyLinkedList();

        num3.addToStart(9);
        num3.addToStart(4);
        num3.addToStart(2);

        num4.addToStart(4);
        num4.addToStart(6);
        num4.addToStart(9);

        num3.print(num3.head);
        num3.print(num4.head);
        sum(num3, num4);
        System.out.println("");

        MyLinkedList num5 = new MyLinkedList();
        MyLinkedList num6 = new MyLinkedList();

        num5.addToStart(9);

        num6.addToStart(4);
        num6.addToStart(6);
        num6.addToStart(9);

        num5.print(num5.head);
        num5.print(num6.head);
        sum(num5, num6);
        System.out.println("");

    }

    public static void sum(MyLinkedList<Integer> num1, MyLinkedList<Integer> num2) {
        MyLinkedList.Node tempNode1 = num1.head;
        MyLinkedList.Node tempNode2 = num2.head;
        int carry = 0;
        MyLinkedList<Integer> sumList = new MyLinkedList<>();

        while (tempNode1 != null && tempNode2 != null) {
            int sum = (int) tempNode1.key + (int)tempNode2.key;
            sumList.addToEnd((sum + carry)%10);
            carry = (sum + carry)/10;
            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;
        }

        if(tempNode1 == null && tempNode2 != null){
            while (tempNode2 != null) {
                int sum = carry + (int)tempNode2.key;
                sumList.addToEnd((sum)%10);
                carry = (sum)/10;
                tempNode2 = tempNode2.next;
            }
        }
        else if(tempNode1 != null && tempNode2 ==null){
            while (tempNode1 != null) {
                int sum = carry + (int)tempNode1.key;
                sumList.addToEnd((sum)%10);
                carry = (sum)/10;
                tempNode1 = tempNode1.next;
            }
        }
        else{
            if(carry != 0){
                sumList.addToEnd(carry);
            }
        }
        sumList.print(sumList.head);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
