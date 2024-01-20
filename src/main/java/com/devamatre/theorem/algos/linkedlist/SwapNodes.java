package com.devamatre.theorem.algos.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 12/1/23 4:02 PM
 */
public class SwapNodes {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapNodes.class);

    /**
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
     * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * <p>
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,4]
     *      Output: [2,1,4,3]
     *
     *  Example 2:
     *      Input: head = []
     *      Output: []
     *
     *  Example 3:
     *      Input: head = [1]
     *      Output: [1]
     * </pre>
     *
     * @param headNode
     * @return
     * @see <url>https://leetcode.com/problems/swap-nodes-in-pairs</url>
     */
    public ListNode swapPairs(ListNode headNode) {
        // list is empty or has only 1 node
        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        // update node pointers
        ListNode nextNode = headNode.next;
        headNode.next = swapPairs(headNode.next.next);
        nextNode.next = headNode;
        headNode = nextNode;

        return headNode;
    }

    /**
     * Returns the size of the linkedList.
     *
     * @param headNode
     * @return
     */
    public int getSize(ListNode headNode) {
        LOGGER.debug("+getSize({})", headNode);
        ListNode curNode = headNode;
        int size = 0;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }

        LOGGER.debug("-getSize(), size:{}", size);
        return size;
    }

    /**
     * You are given the head of a linked list, and an integer k.
     * <p>
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
     * from the end (the list is 1-indexed).
     *
     * <url>https://leetcode.com/problems/swapping-nodes-in-a-linked-list</url>
     *
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,4,5], k = 2
     *      Output: [1,4,3,2,5]
     *  Example 2:
     *      Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     *      Output: [7,9,6,6,8,7,3,0,9,5]
     *  Example 3:
     *      Input: head = [1,2,3,4]
     *      Output: [2,1,4,3]
     *
     *  Example 4:
     *      Input: head = []
     *      Output: []
     *
     *  Example 5:
     *      Input: head = [1]
     *      Output: [1]
     * </pre>
     *
     * @param headNode
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode headNode, int k) {
        LOGGER.debug("+swapNodes({}, {})", headNode, k);
        if (headNode != null) {
            int size = getSize(headNode);
            // if only 1 node, just return the head
            if (size <= 1 && k <= 1) {
                return headNode;
            } else if (size == 2 && k <= 2) {
                ListNode tempNode = headNode.next;
                headNode.next = null;
                tempNode.next = headNode;
                headNode = tempNode;

                return headNode;
            }

            // find previous nodes from the beginning and ending
            int headIndex = k - 1; // parent index from beginning
            int tailIndex = size - k; // parent index from ending
            // if head and tail indexes are same, then same node swap (nothing to do)
            if (headIndex == tailIndex) {
                return headNode;
            }

            LOGGER.debug("headIndex:{}, tailIndex:{}", headIndex, tailIndex);
            // find previous nodes of head and tail nodes.
            ListNode headPrevious = null;
            ListNode tailPrevious = null;
            ListNode curNode = headNode;
            int index = 1;
            while (index < size && curNode != null) {
                if (index == headIndex) {
                    headPrevious = curNode;
                }

                if (index == tailIndex) {
                    tailPrevious = curNode;
                }
                index++;
                curNode = curNode.next;
            }

            // swap node pointers
            LOGGER.debug("headPrevious:{}, tailPrevious:{}", headPrevious, tailPrevious);
            if (headPrevious != null && tailPrevious != null) {
                ListNode tailSwap = tailPrevious.next; // node swap from the ending
                ListNode headSwap = headPrevious.next; // node swap from the beginning
                headPrevious.next = tailPrevious.next;
                tailPrevious.next = headSwap;

                ListNode tailNode = tailSwap.next;
                tailSwap.next = headSwap.next;
                headSwap.next = tailNode;
            } else if (headPrevious == null && tailPrevious != null) {
                ListNode tailSwap = tailPrevious.next; // node swap from the ending
                tailPrevious.next.next = headNode.next;
                headNode.next = null;
                tailPrevious.next = headNode;
                headNode = tailSwap;
            } else if (headPrevious != tailPrevious && tailPrevious == null) {
                ListNode headSwap = headPrevious.next; // node swap from the beginning
                headPrevious.next =  headNode;
                headSwap.next = headNode.next;
                headNode.next = null;
                headNode = headSwap;
            }
        }

        LOGGER.debug("-swapNodes(), headNode:{}", headNode);
        return headNode;
    }

}
