package com.devamatre.theorem.leetcode.linkedlist;

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
public class LC2AddTwoNumbers {

    /**
     * Returns the value of the node if not null otherwise 0.
     *
     * @param headNode
     * @return
     */
    private int getValue(ListNode headNode) {
        return (headNode != null ? headNode.val : 0);
    }

    /**
     * @param headNode
     * @param newValue
     * @return
     */
    private ListNode addNode(ListNode headNode, int newValue) {
        if (headNode == null) {
            headNode = new ListNode(newValue);
        } else {
            headNode.next = addNode(headNode.next, newValue);
        }

        return headNode;
    }

    /**
     * <url>https://leetcode.com/problems/add-two-numbers</url>
     * <p>
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
     * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * <p>
     * Input: left = [2,4,3], right = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807. Example 2:
     * <p>
     * Input: left = [0], right = [0] Output: [0] Example 3:
     * <p>
     * Input: left = [9,9,9,9,9,9,9], right = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode addTwoNumbers(ListNode left, ListNode right) {
        ListNode headNode = null;
        int carry = 0;
        while (left != null || right != null) {
            int sum = getValue(left) + getValue(right) + carry;
            carry = sum / 10;
            sum = sum % 10;
            headNode = addNode(headNode, sum);
            if (left != null) {
                left = left.next;
            }
            if (right != null) {
                right = right.next;
            }
        }

        if (carry > 0) {
            headNode = addNode(headNode, carry);
        }

        return headNode;
    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode addTwoNumbers2(ListNode left, ListNode right) {
        ListNode headNode = new ListNode(0);
        ListNode current = headNode;
        int carry = 0;
        while (left != null || right != null || carry > 0) {
            if (left != null) {
                carry += left.val;
                left = left.next;
            }

            if (right != null) {
                carry += right.val;
                right = right.next;
            }

            current.next = new ListNode(carry % 10);
            carry /= 10;
            current = current.next;
        }

        return headNode.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC2AddTwoNumbers addNumbers = new LC2AddTwoNumbers();
        // left input
        Integer[] leftInput = new Integer[]{9, 9, 9};
        ListNode leftOperand = LinkedListUtils.buildLinkedList(leftInput);

        // right input
        Integer[] rightInput = new Integer[]{9, 9, 9, 9};
        ListNode rightOperand = LinkedListUtils.buildLinkedList(rightInput);

        // sum of lists
        ListNode result = addNumbers.addTwoNumbers(leftOperand, rightOperand);
        System.out.println(result);
    }
}
