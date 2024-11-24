package com.rslakra.theorem.leetcode.linkedlist;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:45 PM
 */
public class LC142LinkedListCycle2 {

    /**
     * <url>https://leetcode.com/problems/linked-list-cycle-ii</url>
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // slow and fast meets, means there is a cycle.
                // reset the slow back to head pointer
                // and move slow and fast both 1 step at a time
                // until slow and fast not meet again.
                // return slow which is the point there is a cycle.
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
