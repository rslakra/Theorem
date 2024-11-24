package com.rslakra.theorem.algos.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 12/4/23 4:33 PM
 */
public class Palindrome {

    private static final Logger LOGGER = LoggerFactory.getLogger(Palindrome.class);

    /**
     * Returns the middle node of the linkedList (uses fast and slow pointer approach).
     * <pre>
     *  Time Complexity: O(N/2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param headNode
     * @return
     */
    private ListNode findMiddle(ListNode headNode) {
        ListNode fastNode = headNode; // hare
        ListNode slowNode = headNode; // tortoise
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }


    /**
     * Returns the middle node of the linkedList (uses fast and slow pointer approach).
     * <pre>
     *  Time Complexity: O(N/2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param headNode
     * @return
     */
    private ListNode findParent(ListNode headNode) {
        ListNode parent = null;
        ListNode fastNode = headNode; // hare
        ListNode slowNode = headNode; // tortoise
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            parent = slowNode;
            slowNode = slowNode.next;
        }

        return parent;
    }

    /**
     * Reverse the linkedList.
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param headNode
     * @return
     */
    private ListNode reverse(ListNode headNode) {
        ListNode prevNode = null;
        ListNode curNode = headNode;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        return prevNode;
    }

    /**
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     *
     * <url>https://leetcode.com/problems/palindrome-linked-list</url>
     *
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,2,1]
     *      Output: true
     *
     *  Example 2:
     *      Input: head = [1,2,2,1]
     *      Output: true
     *
     *  Example 3:
     *      Input: head = [1,2]
     *      Output: false
     *
     *  Example 4:
     *      Input: head = [1]
     *      Output: true
     * </pre>
     *
     * <pre>
     *  Time Complexity: O(N/2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param headNode
     * @return
     */
    public boolean isPalindrome(ListNode headNode) {
        LOGGER.debug("+isPalindrome({})", headNode);
        // list is empty or has only 1 node.
        if (headNode == null || headNode.next == null) {
            LOGGER.debug("-isPalindrome(), true (one node only)");
            return true;
        }

        // find middle of linkedList: O(N/2)
//        ListNode middleNode = findParent(headNode);
        ListNode middleNode = findMiddle(headNode);
        LOGGER.debug("middleNode:{}", middleNode);
        // reverse linkedList: O(N/2)
        ListNode revHead = reverse(middleNode.next);
        LOGGER.debug("revHead:{}", revHead);
        // compare nodes
        while (revHead != null) {
            if (revHead.data != headNode.data) {
                LOGGER.debug("-isPalindrome(), false (not a palindrome)");
                return false;
            }
            revHead = revHead.next;
            headNode = headNode.next;
        }

        LOGGER.debug("-isPalindrome(), true");
        return true;
    }

}
