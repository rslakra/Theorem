package com.rslakra.theorem.leetcode.linkedlist;

/**
 * <url>https://leetcode.com/problems/merge-two-sorted-lists</url>
 *
 * @author Rohtash Lakra
 * @created 1/23/24 12:48 PM
 */
public class LC21MergeTwoSortedLists {

    /**
     * <url>https://leetcode.com/problems/merge-two-sorted-lists/</url>
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsIteratively(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode curr = null;
        while (list1 != null || list2 != null) {
            ListNode tempNode = null;
            if (list1 != null && list2 != null && list1.val <= list2.val) {
                tempNode = list1;
                list1 = list1.next;
            } else if (list1 != null && list2 != null && list1.val > list2.val) {
                tempNode = list2;
                list2 = list2.next;
            } else if (list1 != null && list2 == null) {
                tempNode = list1;
                list1 = list1.next;
            } else if (list1 == null && list2 != null) {
                tempNode = list2;
                list2 = list2.next;
            }

            if (head == null) {
                head = new ListNode(tempNode.val);
                curr = head;
            } else {
                curr.next = (tempNode == null ? null : new ListNode(tempNode.val));
                curr = curr.next;
            }
        }

        return head;
    }


    /**
     * @param list1
     * @param list2
     * @return
     */
    // without creating new ListNode
    public ListNode mergeTwoListsRecursively(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursively(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursively(list1, list2.next);
            return list2;
        }
    }

}
