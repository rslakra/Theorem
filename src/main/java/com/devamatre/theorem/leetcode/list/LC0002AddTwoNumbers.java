package com.devamatre.theorem.leetcode.list;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807. Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 13, 2021 17:26:39
 */
public class LC0002AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
     * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * <p>
     * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807. Example 2:
     * <p>
     * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
     * <p>
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        final ListNode<Integer> tempNode = ListNode.newNode(0);
        ListNode<Integer> current = tempNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.getData();
                l1 = l1.getNext();
            }

            if (l2 != null) {
                carry += l2.getData();
                l2 = l2.getNext();
            }

            current.setNext(ListNode.newNode(carry % 10));
            carry /= 10;
            current = current.getNext();
        }

        return tempNode.getNext();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        LC0002AddTwoNumbers addNumbers = new LC0002AddTwoNumbers();
        ListNode<Integer> leftNode = ListNode.newNode(0);
        leftNode.setNext(ListNode.newNode(9));
        leftNode.getNext().setNext(ListNode.newNode(9));
        leftNode.getNext().getNext().setNext(ListNode.newNode(9));
        System.out.println(leftNode);

        ListNode<Integer> rightNode = ListNode.newNode(9);
        rightNode.setNext(ListNode.newNode(9));
        System.out.println(rightNode);

        ListNode<Integer> result = addNumbers.addTwoNumbers(leftNode, rightNode);
        System.out.println(result);
    }
}
