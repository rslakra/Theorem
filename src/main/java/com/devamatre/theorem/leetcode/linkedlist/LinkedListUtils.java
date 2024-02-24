package com.devamatre.theorem.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 1/23/24 12:51 PM
 */
public enum LinkedListUtils {
    INSTANCE;

    /**
     * Adds the node to the end of the linkedList.
     *
     * @param headNode
     * @param data
     * @return
     */
    private ListNode addNode(ListNode headNode, Integer data) {
        if (Objects.isNull(headNode)) {
            headNode = new ListNode(data);
        } else {
            headNode.next = addNode(headNode.next, data);
        }

        return headNode;
    }

    /**
     * Builds the linkedList of the provided data.
     *
     * @param inputData
     * @return
     */
    public static ListNode buildLinkedList(Integer[] inputData) {
        ListNode headNode = null;
        if (inputData != null) {
            for (int i = 0; i < inputData.length; i++) {
                headNode = INSTANCE.addNode(headNode, inputData[i]);
            }
        }

        return headNode;
    }

    /**
     * Converts the linked list into list of int.
     *
     * @param headNode
     * @return
     */
    private List<Integer> asList(ListNode headNode) {
        List<Integer> linkedList = new ArrayList<>();
        ListNode currNode = headNode;
        while (currNode != null) {
            linkedList.add(currNode.val);
            currNode = currNode.next;
        }

        return linkedList;
    }

    /**
     * Returns the string representation of <code>ListNode</code>.
     *
     * @param headNode
     * @param addBrackets
     * @return
     */
    public String toString(ListNode headNode, boolean addBrackets) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(asList(headNode));
        if (!addBrackets) {
            // remove starting bracket
            strBuilder.delete(0, 1);
            // remove ending bracket
            strBuilder.delete(strBuilder.length() - 1, strBuilder.length());
        }

        return strBuilder.toString();
    }

    /**
     * Returns the string representation of <code>ListNode</code>.
     *
     * @param headNode
     * @return
     */
    public static String toString(ListNode headNode) {
        return INSTANCE.toString(headNode, true);
    }

    /**
     * @param headNode
     * @return
     */
    public static List<Integer> asIntList(ListNode headNode) {
        return INSTANCE.asList(headNode);
    }
}
