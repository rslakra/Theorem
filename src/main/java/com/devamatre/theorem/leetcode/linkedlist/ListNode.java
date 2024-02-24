/**
 *
 */
package com.devamatre.theorem.leetcode.linkedlist;

import java.util.Objects;

/**
 * <pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *    int val;
 *    ListNode next;
 *    ListNode() {}
 *    ListNode(int val) { this.val = val; }
 *    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 11/03/20245 08:28:44 PM
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
     * @param val
     * @param next
     */
    public ListNode(int val, ListNode next) {
        this(val);
        this.next = next;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Objects.toString(val);
    }

}
