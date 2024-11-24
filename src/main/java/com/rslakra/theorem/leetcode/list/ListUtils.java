package com.rslakra.theorem.leetcode.list;

import com.rslakra.appsuite.core.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 1/23/24 12:51 PM
 */
public enum ListUtils {

    INSTANCE;

    /**
     * Adds the node to the end of the linkedList.
     *
     * @param headNode
     * @param data
     * @return
     */
    private <E> ListNode<E> addNode(ListNode<E> headNode, E data) {
        if (Objects.isNull(headNode)) {
            headNode = new ListNode<>(data);
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
    public static <E> ListNode<E> buildLinkedList(E[] inputData) {
        ListNode<E> headNode = null;
        for (int i = 0; i < inputData.length; i++) {
            headNode = INSTANCE.addNode(headNode, inputData[i]);
        }

        return headNode;
    }

    /**
     * Converts the linked list into list of node type.
     *
     * @param headNode
     * @param <E>
     * @return
     */
    private <E> List<E> asList(ListNode<E> headNode) {
        List<E> linkList = new ArrayList<>();
        ListNode<E> currNode = headNode;
        while (currNode != null) {
            linkList.add(currNode.data);
            currNode = currNode.next;
        }

        return linkList;
    }

    /**
     * Returns the string representation of <code>ListNode</code>.
     *
     * @param headNode
     * @param addBrackets
     * @return
     */
    public <E> String toString(ListNode<E> headNode, boolean addBrackets) {
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
     * @param headNode
     * @return
     */
    public static String toString(ListNode headNode) {
        return INSTANCE.toString(headNode, true);
    }

    /**
     * Converts the <code>inputData</code> to <code>Integer</code> type.
     *
     * @param inputData
     * @return
     */
    public static <E> Integer toInteger(E inputData) {
        return BeanUtils.asType(inputData.toString(), Integer.class);
    }

    /**
     * @param headNode
     * @param <E>
     * @return
     */
    public static <E> List<Integer> asIntList(ListNode<E> headNode) {
        return (List<Integer>) INSTANCE.asList(headNode);
    }
}
