package com.devamatre.theorem.leetcode.linkedlist;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:45 PM
 */
public class LC141LinkedListCycle {

    /**
     * <url>https://leetcode.com/problems/linked-list-cycle</url>
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : fast.next;
        }

        return false;
    }

    /**
     * <url>https://leetcode.com/problems/linked-list-cycle</url>
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
