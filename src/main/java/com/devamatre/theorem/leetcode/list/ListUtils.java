package com.devamatre.theorem.leetcode.list;

import com.devamatre.theorem.leetcode.linkedlist.ListNode;

/**
 * @author Rohtash Lakra
 * @created 1/23/24 12:51 PM
 */
public enum ListUtils {

    INSTANCE;

    /**
     * Builds the linkedList of the provided data.
     *
     * @param inputData
     * @return
     */
    public ListNode buildLinkedList(Integer[] inputData) {
        ListNode headNode = null;
        return headNode;
    }

    /**
     * Returns the string representation of <code>ListNode</code>.
     *
     * @param headNode
     * @return
     */
    public String toString(ListNode headNode) {
        StringBuilder strBuilder = new StringBuilder("[");
        ListNode currNode = headNode;
        while (currNode != null) {
            strBuilder.append(currNode.val);
            if (currNode.next != null) {
                strBuilder.append(", ");
            }
            currNode = currNode.next;
        }

        return strBuilder.append("]").toString();

    }

}
