/**
 *
 */
package com.devamatre.theorem.leetcode.linkedlist;

import java.util.Objects;

/**
 * * public class ListNode { *     int val; *     ListNode next; *     ListNode() {} *     ListNode(int val) { this.val
 * = val; } *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *
 * @author Rohtash Lakra
 */
public class ListNode {

    public int val;
    public ListNode next;

    /**
     * @param val
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Objects.toString(val);
    }

}
