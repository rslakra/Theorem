package com.rslakra.theorem.leetcode.linkedlist;

import com.rslakra.theorem.leetcode.list.ListNode;
import com.rslakra.theorem.leetcode.list.ListUtils;

/**
 * @author Rohtash Lakra
 * @created 1/24/24 2:06 PM
 */
public class SumLinkedList extends LinkedList<Integer> {

    /**
     * Returns the sum of the left and right operands.
     *
     * @param leftOperand
     * @param rightOperand
     * @return
     */
    @Override
    protected Integer sumNodes(ListNode<Integer> leftOperand, ListNode<Integer> rightOperand) {
        if (leftOperand == null) {
            return ListUtils.toInteger(rightOperand.data);
        } else if (rightOperand == null) {
            return ListUtils.toInteger(leftOperand.data);
        } else {
            return ListUtils.toInteger(leftOperand.data) + ListUtils.toInteger(rightOperand.data);
        }
    }

    /**
     * Returns the sum linked-list of the 2 linked lists.
     *
     * @param other
     * @return
     */
    public LinkedList<Integer> sum(LinkedList<Integer> other) {
        LinkedList<Integer> sumList = new LinkedList<>();
        if (other != null || this != null) {
            ListNode<Integer> leftOperand = getHead();
            ListNode<Integer> rightOperand = other.getHead();
            int carry = 0;
            while (leftOperand != null || rightOperand != null) {
                int sum = sumNodes(leftOperand, rightOperand) + carry;
                carry = sum / 10;
                sum = sum % 10;
                sumList.addNode(sum);
                if (leftOperand != null) {
                    leftOperand = leftOperand.next;
                }

                if (rightOperand != null) {
                    rightOperand = rightOperand.next;
                }
            }

            if (carry > 0) {
                sumList.addNode(carry);
            }
        }

        return sumList;
    }
}
